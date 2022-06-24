package com.example.consumer.Service.Impl;

import com.example.common.Service.Userservice;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    @DubboReference
    private Userservice userservice;

    public String getOrder() {
        return userservice.getUser();
    }
}
