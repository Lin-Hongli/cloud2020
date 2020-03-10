package com.lhl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lhl
 * @create 2020/3/10 1:46
 */
@Service
public class PaymentService {

    //=============服务降级
    /**
     * 正常访问方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t";
    }

    /**
     * 服务端的降级处理，一般放在客户端
     * 1.paymentInfo_TimeOutHandler超时或报错的处理方案，
     * 2.设定最高峰值时间，即多少秒内未处理完即为处理失败@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
     * 超过峰值时间调用处理方案，报错立即调用处理方案
     * 3.主启动类激活
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //假设服务完成所需的最长时间,或服务报错
        //int i=1/0;
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id+ "\t" + "耗时" + time;
    }

    /**
     * follback,兜底方案，超时时的解决方案
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler,id: " + id +"系统忙";
    }

    //==============服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            //十秒后最后十次请求，失败率达到60%就熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗口期，断开10秒后进入半开状态尝试恢复，若成功则闭合，若失败则继续休眠10秒
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //最近十秒内总请求数失败率达到60%后熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("***id 不能负数");
        }
        /*糊涂工具类，生成不带-的uuid*/
        String serialNumber= IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "系统异常，请稍后再试"+id;
    }

}

