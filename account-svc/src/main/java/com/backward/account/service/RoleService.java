package com.backward.account.service;

import com.backward.account.dmo.RoleDmo;
import com.backward.account.dmo.UserRoleDmo;

import java.util.List;

public interface RoleService {

    /**
     * 获取全部角色信息
     * @return
     */
    List<RoleDmo> getAllRoleInfo();

    /**
     * 添加新角色
     * @param roleDmo
     * @return
     */
    int addNewRole(RoleDmo roleDmo);

    /**
     * 删除角色
     * @param rolename
     * @return
     */
    int deleteRole(String rolename);

    /**
     * 修改角色描述
     * @param role
     * @param description
     * @return
     */
    int alterRoleDescription(String role, String description);

    /**
     * 查询所有用户角色关系记录
     * @return
     */
    List<UserRoleDmo> selectAllUserRoleRecord();

}
