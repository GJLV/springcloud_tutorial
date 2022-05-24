package com.sap.springily.controller;

import com.sap.springily.entities.CommonResult;
import com.sap.springily.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //要在这里调用8001 就是service之间的调用
    //原始的做法是HTTPCClient  但是springcloud封装了之后可以用restTemplate实现  客户端模板工具类
    //类似的还有JDBCTemplate RedisTemplate等等
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("创建");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("开始获取");
        System.out.println("aaa");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id,CommonResult.class );
    }

}
