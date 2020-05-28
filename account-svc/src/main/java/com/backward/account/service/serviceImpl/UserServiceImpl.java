package com.backward.account.service.serviceImpl;

import com.backward.account.dao.UserDao;
import com.backward.account.dao.UserRoleDao;
import com.backward.account.dmo.UserDmo;
import com.backward.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public int createNewUser(UserDmo userDmo) {
        return userDao.insert(userDmo);
    }

    @Override
    public UserDmo getUserInfo(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public int deleteUserByUsername(String username) {
        int res = userDao.deleteByUsername(username);
        userRoleDao.deleteByUsername(username);
        return res;
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        return BCrypt.checkpw(password, userDao.selectPasswordByUsername(username));
    }
}
