package com.backward.account.service;

import com.backward.account.dmo.AuthDmo;
import com.backward.account.dmo.RoleAuthDmo;
import com.backward.account.dmo.RoleDmo;
import com.backward.account.dmo.UserRoleDmo;

import java.util.List;

public interface AuthService {

    /**
     * 获取全部权限信息
     * @return
     */
    List<AuthDmo> getAllAuthInfo();

    /**
     * 添加新权限
     * @param authDmo
     * @return
     */
    int addNewAuthority(AuthDmo authDmo);

    /**
     * 删除权限
     * @param authority
     * @return
     */
    int deleteAuthority(String authority);

    /**
     * 修改角色描述
     * @param authority
     * @param description
     * @return
     */
    int alterAuthDescription(String authority, String description);

    /**
     * 查询所有角色权限关系记录
     * @return
     */
    List<RoleAuthDmo> selectAllRoleAuthRecord();
}
