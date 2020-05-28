package com.backward.account.controller;

import com.alibaba.fastjson.JSON;
import com.backward.account.dmo.AuthDmo;
import com.backward.account.dto.request.AlterAuthDescriptionRequest;
import com.backward.account.service.AuthService;
import com.backward.common.api.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Api(value = "Auth API", tags = {"Auth API"})
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    /**
     * 获取全部权限信息
     * @return
     */
    @ApiOperation(value = "获取所有权限信息")
    @GetMapping("/auth_info")
    BaseResponse getAllAuth(){
        String res = JSON.toJSONString(authService.getAllAuthInfo());
        return BaseResponse.builder().message(res).build();
    }

    /**
     * 添加新权限
     * @param authDmo
     * @return
     */
    @ApiOperation(value = "添加新权限")
    @PostMapping("/add_auth")
        BaseResponse addNewAuth(@RequestBody AuthDmo authDmo){
        int msg = authService.addNewAuthority(authDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 删除权限
     * @param authority
     * @return
     */
    @ApiOperation(value = "删除权限")
    @Transactional(rollbackFor = Throwable.class)
    @DeleteMapping("/delete_auth")
    BaseResponse deleteAuth(@RequestParam("authority") String authority){
        int msg = authService.deleteAuthority(authority);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 修改权限描述
     * @param request
     * @return
     */
    @ApiOperation(value = "修改权限描述")
    @PostMapping("/alter_auth_description")
    BaseResponse alterAuthDescription(@RequestBody AlterAuthDescriptionRequest request){
        int msg = authService.alterAuthDescription(request.getAuthority(), request.getDescription());
        return BaseResponse.builder().message(Integer.toString(msg)).build();

    }

    /**
     * 查询所有角色权限记录
     * @return
     */
    @ApiOperation(value = "查询所有角色权限记录")
    @GetMapping("/role_auth_info")
    BaseResponse getAllRoleAuthInfo(){
        String res = JSON.toJSONString(authService.selectAllRoleAuthRecord());
        return BaseResponse.builder().message(res).build();
    }

}
