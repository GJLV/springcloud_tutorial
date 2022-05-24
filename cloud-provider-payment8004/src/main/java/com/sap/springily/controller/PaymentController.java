package com.sap.springily.controller;

import com.sap.springily.entities.CommonResult;
import com.sap.springily.entities.Payment;
import com.sap.springily.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j //日志
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPort;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        int test = 10/2;
        if (result>0){
            return new CommonResult(200,"success,serverport" + serverPort,result);
        }else{
            return new CommonResult(404,"failed");
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果" + result);
        if (result != null){
            return new CommonResult(200,"查询成功,serverport" +serverPort,result);
        }else{
            return new CommonResult(404,"查询失败，没有对应记录"+id,null);
        }
    }

}
