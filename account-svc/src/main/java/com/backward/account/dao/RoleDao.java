package com.backward.account.dao;

import com.backward.account.dmo.RoleDmo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {

    /**
     * 获取所有角色信息
     * @return
     */
    List<RoleDmo> selectRoles();

    /**
     * 添加新角色
     * @param roleDmo
     * @return
     */
    int insert(RoleDmo roleDmo);

    /**
     * 删除某角色
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
    int updateDescription(@Param("role")String role, @Param("description")String description);

}
