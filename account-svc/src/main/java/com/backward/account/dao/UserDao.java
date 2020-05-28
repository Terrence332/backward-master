package com.backward.account.dao;

import com.backward.account.dmo.UserDmo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    /**
     * 添加新用户
     * @param userDmo
     * @return
     */
    int insert(UserDmo userDmo);

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    UserDmo selectByUsername(String username);

    /**
     * 根据用户名删除用户信息
     * @param username
     * @return
     */
    int deleteByUsername(String username);

    /**
     * 根据用户名查询用户密码
     * @param username
     * @return
     */
    String selectPasswordByUsername(String username);

    /**
     * 根据用户名名更新密码
     * @param username
     * @param password
     * @return
     */
    int updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名更新邮箱
     * @param username
     * @param e_mail
     * @return
     */
    int updateEmailByUsername(@Param("username") String username, @Param("e_mail")String e_mail);
}
