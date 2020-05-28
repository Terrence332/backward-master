package com.backward.account.controller;

import com.alibaba.fastjson.JSON;
import com.backward.account.dmo.RoleAuthDmo;
import com.backward.account.dmo.UserDmo;
import com.backward.account.dmo.UserRoleDmo;
import com.backward.account.dto.UserDetailsDto;
import com.backward.account.dto.request.AlterEmailRequest;
import com.backward.account.dto.request.AlterUserPasswordRequest;
import com.backward.account.dto.response.UserDetailResponse;
import com.backward.account.service.AccountService;
import com.backward.account.service.UserService;
import com.backward.common.api.BaseResponse;
import com.backward.common.exception.WrongPasswordException;
import com.backward.common.tools.UserInfoTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Api(value = "Account API", tags = {"Account API"})
@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    /**
     * 注册新用户
     * @param userDmo
     * @return
     */
    @ApiOperation(value = "注册新用户")
    @PostMapping("/register")
    BaseResponse register(@RequestBody UserDmo userDmo){
        if(userDmo.getPassword() != null){
            String encodedSecret = BCrypt.hashpw(userDmo.getPassword(), BCrypt.gensalt());
            userDmo.setPassword(encodedSecret);
        }
        int msg = userService.createNewUser(userDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 删除用户
     * @param username
     * @return
     */
    @ApiOperation(value = "删除用户")
    @Transactional(rollbackFor = Throwable.class)
    @DeleteMapping("/delete_user")
    BaseResponse delete(@RequestParam String username){
        int msg = userService.deleteUserByUsername(username);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 用户修改密码
     * @param request
     * @return
     * @throws WrongPasswordException
     */
    @ApiOperation(value = "修改用户密码")
    @Transactional(rollbackFor = Throwable.class)
    @PostMapping("/update_password")
    BaseResponse updatePassword(@RequestBody AlterUserPasswordRequest request) throws WrongPasswordException {
        String username = UserInfoTools.getCurrentUsername();
        if(userService.checkUserPassword(username, request.getOldPassword())){
            int msg = accountService.updatePasswordByUsername(username, BCrypt.hashpw(request.getNewPassword(), BCrypt.gensalt()));
            return BaseResponse.builder().message(Integer.toString(msg)).build();
        }else{
            throw new WrongPasswordException();
        }
    }

    /**
     * 用户修改邮箱地址
     * @param request
     * @return
     * @throws WrongPasswordException
     */
    @ApiOperation(value = "修改用户邮箱")
    @Transactional(rollbackFor = Throwable.class)
    @PostMapping("/update_email")
    BaseResponse updateEmail(@RequestBody AlterEmailRequest request) throws WrongPasswordException {
        String username = UserInfoTools.getCurrentUsername();
        if(userService.checkUserPassword(username, request.getPassword())){
            int msg = accountService.updateEmailByUsername(username, request.getE_mail());
            return BaseResponse.builder().message(Integer.toString(msg)).build();
        }else{
            throw new WrongPasswordException();
        }
    }

    /**
     * 根据用户名获取用户角色
     * @param username
     * @return
     */
    @ApiOperation(value = "查询用户角色")
    @GetMapping("/role_of_user")
    BaseResponse getRoleByUsername(@RequestParam String username){
        String res = JSON.toJSONString(accountService.getRolesByUsername(username));
        return BaseResponse.builder().message(res).build();
    }

    /**
     * 根据角色获取权限
     * @param role
     * @return
     */
    @ApiOperation(value = "查询角色权限")
    @GetMapping("/auth_of_role")
    BaseResponse getAuthByRole(@RequestParam String role){
        String res = JSON.toJSONString(accountService.getAuthByRole(role));
        return BaseResponse.builder().message(res).build();
    }

    /**
     * 根据用户获取权限
     * @param username
     * @return
     */
    @ApiOperation(value = "查询用户权限")
    @GetMapping("/auth_of_user")
    BaseResponse getAuthByUsername(@RequestParam String username){
        String res = JSON.toJSONString(accountService.getAuthByUsername(username));
        return BaseResponse.builder().message(res).build();
    }

    /**
     * 赋予用户新角色
     * @param userRoleDmo
     * @return
     */
    @ApiOperation(value = "为用户添加新角色")
    @PostMapping("/grant_role")
    BaseResponse grantUserNewRole(@RequestBody UserRoleDmo userRoleDmo){
        int msg = accountService.grantUserNewRole(userRoleDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 赋予角色新权限
     * @param roleAuthDmo
     * @return
     */
    @ApiOperation(value = "为角色添加新权限")
    @PostMapping("/grant_auth")
    BaseResponse grantRoleNewAuth(@RequestBody RoleAuthDmo roleAuthDmo){
        int msg = accountService.grantRoleNewAuth(roleAuthDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    @ApiOperation(value = "获取User Detail(供Auth Server使用，网关对外屏蔽)")
    @GetMapping("/auth_only/user_details")
    UserDetailResponse getUserDetails(@RequestParam String username){
        UserDmo userInfo = userService.getUserInfo(username);
        String authorities = JSON.toJSONString(accountService.getAuthByUsername(username));
        UserDetailsDto userDetails = UserDetailsDto.builder()
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .authorities(authorities)
                .accountNonExpired(userInfo.isAccountNonExpired())
                .accountNonLocked(userInfo.isAccountNonLocked())
                .credentialsNonExpired(userInfo.isCredentialsNonExpired())
                .enabled(userInfo.isEnabled())
                .build();
        return new UserDetailResponse(userDetails);
    }

}
