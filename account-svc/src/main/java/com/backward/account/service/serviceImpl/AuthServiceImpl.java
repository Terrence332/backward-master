package com.backward.account.service.serviceImpl;

import com.backward.account.dao.AuthDao;
import com.backward.account.dao.RoleAuthDao;
import com.backward.account.dmo.AuthDmo;
import com.backward.account.dmo.RoleAuthDmo;
import com.backward.account.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthDao authDao;

    @Autowired
    RoleAuthDao roleAuthDao;

    @Override
    public List<AuthDmo> getAllAuthInfo() {
        return authDao.selectAuthorities();
    }

    @Override
    public int addNewAuthority(AuthDmo authDmo) {
        return authDao.insert(authDmo);
    }

    @Override
    public int deleteAuthority(String authority) {
        int res = authDao.deleteAuthority(authority);
        roleAuthDao.deleteByAuth(authority);
        return res;
    }

    @Override
    public int alterAuthDescription(String authority, String description) {
        return authDao.updateDescription(authority, description);
    }

    @Override
    public List<RoleAuthDmo> selectAllRoleAuthRecord() {
        return roleAuthDao.selectAllRecord();
    }
}
