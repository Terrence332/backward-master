package com.backward.account.service;

import com.backward.account.dmo.RoleAuthDmo;
import com.backward.account.dmo.UserRoleDmo;

import java.util.List;

public interface AccountService {

    /**
     * 更新用户密码
     * @param username
     * @param password
     * @return
     */
    int updatePasswordByUsername(String username, String password);

    /**
     * 更新用户邮箱
     * @param username
     * @param e_mail
     * @return
     */
    int updateEmailByUsername(String username, String e_mail);

    /**
     * 根据用户名获取角色
     * @param username
     * @return
     */
    List<String> getRolesByUsername(String username);

    /**
     * 根据角色获取角色权限
     * @param role
     * @return
     */
    List<String> getAuthByRole(String role);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    List<String> getAuthByUsername(String username);

    /**
     * 赋予用户新角色
     * @param userRoleDmo
     * @return
     */
    int grantUserNewRole(UserRoleDmo userRoleDmo);

    /**
     * 赋予角色新权限
     * @param roleAuthDmo
     * @return
     */
    int grantRoleNewAuth(RoleAuthDmo roleAuthDmo);

}
