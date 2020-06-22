package com.longgood.maintainmanage.beanpostprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/*/
 拦截redis生成bean，给bean设置属性。
 */
@Component
public class RedisBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        //System.out.println("之前"+beanName);
        if (bean instanceof RedisTemplate) {
            ((RedisTemplate) bean).setKeySerializer(new StringRedisSerializer());
            ((RedisTemplate) bean).setHashKeySerializer(new StringRedisSerializer());
            ((RedisTemplate) bean).setHashValueSerializer(new Jackson2JsonRedisSerializer(Long.TYPE));
            ((RedisTemplate) bean).setValueSerializer(new JdkSerializationRedisSerializer());
        }
        return bean;
    }
}
