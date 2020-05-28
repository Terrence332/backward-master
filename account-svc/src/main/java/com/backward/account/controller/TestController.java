package com.backward.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Test API", tags = {"Test API"})
@RestController
public class TestController {

    @ApiOperation(value = "Fegin Test")
    @PreAuthorize("hasAuthority('p1')")
    @GetMapping("/test")
    String test(){
        return "this is a feign test";
    }

}
