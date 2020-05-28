package com.backward.account.service.serviceImpl;

import com.backward.account.dao.RoleAuthDao;
import com.backward.account.dao.UserDao;
import com.backward.account.dao.UserRoleDao;
import com.backward.account.dmo.RoleAuthDmo;
import com.backward.account.dmo.RoleDmo;
import com.backward.account.dmo.UserRoleDmo;
import com.backward.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    RoleAuthDao roleAuthDao;

    @Override
    public int updatePasswordByUsername(String username, String password) {
        return userDao.updatePasswordByUsername(username, password);
    }

    @Override
    public int updateEmailByUsername(String username, String e_mail) {
        return userDao.updateEmailByUsername(username, e_mail);
    }

    @Override
    public List<String> getRolesByUsername(String username) {
        return userRoleDao.selectRoleByUsername(username);
    }

    @Override
    public List<String> getAuthByRole(String role) {
        return roleAuthDao.selectAuthByRole(role);
    }

    @Override
    public List<String> getAuthByUsername(String username) {
        return roleAuthDao.selectAuthByUsername(username);
    }

    @Override
    public int grantUserNewRole(UserRoleDmo userRoleDmo) {
        return userRoleDao.insert(userRoleDmo);
    }

    @Override
    public int grantRoleNewAuth(RoleAuthDmo roleAuthDmo) {
        return roleAuthDao.insert(roleAuthDmo);
    }


}
