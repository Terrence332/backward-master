package com.backward.account.dao;

import com.backward.account.dmo.AuthDmo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthDao {
    /**
     * 获取所有权限信息
     * @return
     */
    List<AuthDmo> selectAuthorities();

    /**
     * 添加新权限
     * @param authDmo
     * @return
     */
    int insert(AuthDmo authDmo);

    /**
     * 删除某权限
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
    int updateDescription(@Param("authority")String authority, @Param("description")String description);
}
