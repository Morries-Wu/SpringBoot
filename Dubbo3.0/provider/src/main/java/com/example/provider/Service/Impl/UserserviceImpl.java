package com.example.provider.Service.Impl;

import com.example.common.Service.Userservice;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserserviceImpl implements Userservice {
    public String getUser() {
        return "Morries_Wu";
    }
}
