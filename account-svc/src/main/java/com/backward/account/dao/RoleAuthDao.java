package com.backward.account.dao;

import com.backward.account.dmo.RoleAuthDmo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleAuthDao {
    /**
     * 获取全部角色-权限记录
     * @return
     */
    List<RoleAuthDmo> selectAllRecord();

    /**
     * 根据角色获取权限
     * @param role
     * @return
     */
    List<String> selectAuthByRole(String role);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    List<String> selectAuthByUsername(String username);

    /**
     * 插入新的角色记录
     * @param roleAuthDmo
     * @return
     */
    int insert(RoleAuthDmo roleAuthDmo);

    /**
     * 根据角色删除记录
     * @param role
     * @return
     */
    int deleteByRole(String role);

    /**
     * 根据权限删除记录
     * @param authority
     * @return
     */
    int deleteByAuth(String authority);
}
