package com.backward.account.service;

import com.backward.account.dmo.UserDmo;

public interface UserService {

    /**
     * 创建一个新用户
     * @param userDmo
     * @return
     */
    int createNewUser(UserDmo userDmo);

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    UserDmo getUserInfo(String username);

    /**
     * 根据用户名删除一个用户
     * @param username
     * @return
     */
    int deleteUserByUsername(String username);

    /**
     * 检验用户密码与数据库是否匹配
     * @param username
     * @param password
     * @return
     */
    boolean checkUserPassword(String username, String password);
}
