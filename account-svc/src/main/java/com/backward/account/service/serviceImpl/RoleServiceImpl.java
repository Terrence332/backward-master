package com.backward.account.service.serviceImpl;

import com.backward.account.dao.RoleAuthDao;
import com.backward.account.dao.RoleDao;
import com.backward.account.dao.UserRoleDao;
import com.backward.account.dmo.RoleDmo;
import com.backward.account.dmo.UserRoleDmo;
import com.backward.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    RoleAuthDao roleAuthDao;

    @Override
    public List<RoleDmo> getAllRoleInfo() {
        return roleDao.selectRoles();
    }

    @Override
    public int addNewRole(RoleDmo roleDmo) {
        return roleDao.insert(roleDmo);
    }

    @Override
    public int deleteRole(String rolename) {
        int res = roleDao.deleteRole(rolename);
        userRoleDao.deleteByRole(rolename);
        roleAuthDao.deleteByRole(rolename);
        return res;
    }

    @Override
    public int alterRoleDescription(String role, String description) {
        return roleDao.updateDescription(role, description);
    }

    @Override
    public List<UserRoleDmo> selectAllUserRoleRecord() {
        return userRoleDao.selectAllRecord();
    }


}
