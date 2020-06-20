package com.longgood.maintainmanage.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.longgood.maintainmanage.auth.entity.YwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Long.TYPE));
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        JwtUtils.redisTemplate = redisTemplate;
    }

    //三十天 token过期
    private static final long refreshTokenMillis = 1000 * 60 * 60 * 24 * 30L;
    private static final long tokenMillis = 1000 *  10L;
    private static final String TOKEN_KEY = "LONGGOOD_TOKEN";
    private static final String SECRET_KEY = "123456";

    public static String createToken(YwUser user) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        long l = System.currentTimeMillis();
        Date date = new Date(l + tokenMillis);
        try {
            redisTemplate.opsForHash().put(TOKEN_KEY, user.getUserid(), l + refreshTokenMillis);
        } catch (Exception e) {
            System.out.println(e);
        }
        return JWT.create().withClaim("userName", user.getUsername())
                .withClaim("userId", user.getUserid())
                .withExpiresAt(date).sign(algorithm);
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm).build();
            // 验证 token
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException ex) { //如果是过期了 则查看redis中的刷新token是否过期
            YwUser user = getUser(token);
            long l = System.currentTimeMillis();
            Object time = redisTemplate.opsForHash().get(TOKEN_KEY, user.getUserid());
            if (time != null) {
                //如果当前时间大于redis时间，说明很久没有登录了。
                if (System.currentTimeMillis() > (long) time) {
                    throw ex;
                } else {//如果小于，说明还是活动用户，将过期时间往后延，并重新返回token
                    redisTemplate.opsForHash().put(TOKEN_KEY, user.getUserid(), l + refreshTokenMillis);
                    return false;
                }
            } else {
                throw ex;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


    public static YwUser getUser(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            YwUser user = new YwUser();
            user.setUsername(jwt.getClaim("userName").asString());
            user.setUserid(jwt.getClaim("userId").asString());
            return user;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
