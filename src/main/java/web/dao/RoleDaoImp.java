package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

@Repository
public class RoleDaoImp implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Role findByName(String name) {
        try {
            Role role = (Role) sessionFactory.getCurrentSession()
                    .createQuery("from Role WHERE name= :name")
                    .setParameter("name", name)
                    .uniqueResult();
            return role;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }
}
