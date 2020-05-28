package com.backward.sres.controller;

import com.backward.account.client.AccountClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "资源服务样例", tags = {"资源服务样例"})
@RestController
public class TestController {

    @Autowired
    AccountClient accountClient;

    @ApiOperation(value = "访问样例资源r1")
    @GetMapping("/r/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1() { return "访问资源r1"; }

    @ApiOperation(value = "访问样例资源r2")
    @GetMapping("/r/r2")
    @PreAuthorize("hasAuthority('p2')")
    public String r2(){
        return "访问资源r2";
    }

    @ApiOperation(value = "Feign测试")
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('p1')")
    public String test(){
        return accountClient.test();
    }
}
