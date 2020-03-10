package com.lhl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用Feign的日志
 * @author lhl
 * @create 2020/3/10 1:00
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){

        //NONE,BASIC,HEADERS,FULL;四种feign的日志级别
        return Logger.Level.FULL;
    }
}
