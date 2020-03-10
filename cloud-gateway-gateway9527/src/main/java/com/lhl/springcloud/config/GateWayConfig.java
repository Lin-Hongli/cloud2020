package com.lhl.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhl
 * @create 2020/3/10 23:09
 */
@Configuration
public class GateWayConfig {
    //编码式配置网关
    /*@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("blog", r ->
                        r.path("...").uri("...."))
                .build();
    }*/

    //断言配置
    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return  builder.routes()
                .route(r -> r.host("**.yuqiyu.com")
                        .and().path("/api-boot-datasource-switch.html")
                        .and().method("GET")
                        .uri("http://blog.yuqiyu.com")
                        .order(1)
                        .id("blog")
                )
                .build();
    }*/
}
