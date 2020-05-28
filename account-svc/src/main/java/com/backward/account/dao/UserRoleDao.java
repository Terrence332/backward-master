package com.backward.account.dao;

import com.backward.account.dmo.UserRoleDmo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRoleDao {

    /**
     * 获取全部用户名-角色记录
     * @return
     */
    List<UserRoleDmo> selectAllRecord();

    /**
     * 根据用户名获取用户角色
     * @param username
     * @return
     */
    List<String> selectRoleByUsername(String username);

    /**
     * 插入新的用户名-角色记录
     * @param userRoleDmo
     * @return
     */
    int insert(UserRoleDmo userRoleDmo);

    /**
     * 根据用户名删除记录
     * @param username
     * @return
     */
    int deleteByUsername(String username);

    /**
     * 根据角色删除记录
     * @param role
     * @return
     */
    int deleteByRole(String role);
}
