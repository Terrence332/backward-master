package com.backward.sres.controller;

import com.backward.common.tools.UserInfoTools;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @ApiOperation(value = "获取用户信息测试 ")
    @PostMapping(value = "/username")
    @PreAuthorize("hasAuthority('p1')")
    public String username(){
        return UserInfoTools.getCurrentUsername();
    }
}
