package com.lhl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhl
 * @create 2020/3/9 22:04
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){



        //默认为轮询
        return new RandomRule();//自定义为负载算法为随机
        //return new WeightedResponseTimeRule();//根据响应虚度，越快越容易被选
        //return new AvailabilityFilteringRule();//过滤故障，再选择并发量小的
        //....

    }
}
