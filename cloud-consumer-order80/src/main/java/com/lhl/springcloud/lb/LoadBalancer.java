package com.lhl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lhl
 * @create 2020/3/9 22:41
 */
public interface LoadBalancer {

    //获取服务实例
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
