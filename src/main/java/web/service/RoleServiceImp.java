package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;
import web.model.User;

import java.util.List;

@Service
//@Transactional("jpaTrans")
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleByName(String name) {
//        List<Role> list = roleDao.findAll();
//        for (Role role : list) {
//            if (role.getName().equals(name)){
//                return role;
//            }
//        }
        return roleDao.findByName(name);
    }
}
