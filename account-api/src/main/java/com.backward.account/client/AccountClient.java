package com.backward.account.client;

import com.backward.account.AccountConstant;
import com.backward.account.dmo.*;
import com.backward.account.dto.request.*;
import com.backward.account.dto.response.ClientDetailResponse;
import com.backward.account.dto.response.UserDetailResponse;
import com.backward.common.api.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Terrence332
 * @version 0.1
 * account服务api，其他服务通过注入AccountClient实现对account服务的调用
 */
@FeignClient(name= AccountConstant.SERVICE_NAME)
public interface AccountClient {

    /*AccountController*/
    @PostMapping("/register")
    BaseResponse register(@RequestBody UserDmo userDmo);

    @DeleteMapping("/delete_user")
    BaseResponse delete(@RequestParam("username") String username);

    @PostMapping("/update_password")
    BaseResponse updatePassword(@RequestBody AlterUserPasswordRequest request);

    @PostMapping("/update_email")
    BaseResponse updateEmail(@RequestBody AlterEmailRequest request);

    @GetMapping("/role_of_user")
    BaseResponse getRoleByUsername(@RequestParam("username") String username);

    @GetMapping("/auth_of_role")
    BaseResponse getAuthByRole(@RequestParam("role") String role);

    @GetMapping("/auth_of_user")
    BaseResponse getAuthByUsername(@RequestParam("username") String username);

    @PostMapping("/grant_role")
    BaseResponse grantUserNewRole(@RequestBody UserRoleDmo userRoleDmo);

    @PostMapping("/grant_auth")
    BaseResponse grantRoleNewAuth(@RequestBody RoleAuthDmo roleAuthDmo);

    @GetMapping(path = "/auth_only/user_details")
    UserDetailResponse getUserDetails(@RequestParam("username") String username);

    /*AuthController*/
    @GetMapping("/auth_info")
    BaseResponse getAllAuth();

    @PostMapping("/add_auth")
    BaseResponse addNewAuth(@RequestBody AuthDmo authDmo);

    @DeleteMapping("/delete_auth")
    BaseResponse deleteAuth(@RequestParam("authority") String authority);

    @PostMapping("/alter_auth_description")
    BaseResponse alterAuthDescription(@RequestBody AlterAuthDescriptionRequest request);

    @GetMapping("/role_auth_info")
    BaseResponse getAllRoleAuthInfo();

    /*ClientController*/
    @GetMapping("/client_details")
    ClientDetailResponse getClientInformationByClientId(@RequestParam("clientId") String clientId);

    @PostMapping("/register_client")
    BaseResponse registerNewClient(@RequestBody ClientDmo clientDmo);

    @DeleteMapping("/delete_client")
    int deleteClientByClientId(@RequestParam("clientId") String clientId);

    @PostMapping("/alter_secret")
    int alterClientSecretByClientId(@RequestBody AlterClientPasswordRequest request);

    /*RoleController*/
    @GetMapping("/roles_info")
    BaseResponse getAllRoles();

    @PostMapping("/add_role")
    BaseResponse addNewRole(@RequestBody RoleDmo roleDmo);

    @DeleteMapping("/delete_role")
    BaseResponse deleteRole(@RequestParam("role") String rolename);

    @PostMapping("/alter_role_description")
    BaseResponse alterRoleDescription(@RequestBody AlterRoleDescriptionRequest request);

    @GetMapping("/user_role_info")
    BaseResponse getAllUserRoleInfo();

    /*TestController*/
    @GetMapping(path = "/test")
    String test();

}
