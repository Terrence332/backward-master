package com.backward.account.controller;

import com.alibaba.fastjson.JSON;
import com.backward.account.dmo.RoleDmo;
import com.backward.account.dto.request.AlterRoleDescriptionRequest;
import com.backward.account.service.RoleService;
import com.backward.common.api.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Api(value = "Role API", tags = {"Role API"})
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 获取全部角色信息
     * @return
     */
    @ApiOperation(value = "获取全部角色信息")
    @GetMapping("/roles_info")
    BaseResponse getAllRoles(){
        String res = JSON.toJSONString(roleService.getAllRoleInfo());
        return BaseResponse.builder().message(res).build();
    }

    /**
     * 添加新角色
     * @param roleDmo
     * @return
     */
    @ApiOperation(value = "添加新角色")
    @PostMapping("/add_role")
    BaseResponse addNewRole(@RequestBody RoleDmo roleDmo){
        int msg = roleService.addNewRole(roleDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 删除角色
     * @param rolename
     * @return
     */
    @ApiOperation(value = "删除角色")
    @Transactional(rollbackFor = Throwable.class)
    @DeleteMapping("/delete_role")
    BaseResponse deleteRole(@RequestParam("role") String rolename){
        int msg = roleService.deleteRole(rolename);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 修改角色描述
     * @param request
     * @return
     */
    @ApiOperation(value = "修改角色描述")
    @PostMapping("/alter_role_description")
    BaseResponse alterRoleDescription(@RequestBody AlterRoleDescriptionRequest request){
        int msg = roleService.alterRoleDescription(request.getRole(), request.getDescription());
        return BaseResponse.builder().message(Integer.toString(msg)).build();

    }

    /**
     * 查询所有用户角色记录
     * @return
     */
    @ApiOperation(value = "获取所有用户角色记录")
    @GetMapping("/user_role_info")
    BaseResponse getAllUserRoleInfo(){
        String res = JSON.toJSONString(roleService.selectAllUserRoleRecord());
        return BaseResponse.builder().message(res).build();
    }
}
