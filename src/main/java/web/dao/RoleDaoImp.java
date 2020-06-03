package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
//@Transactional("jpaTrans")
public class RoleDaoImp implements RoleDao {//
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = entityManager
                .createQuery("select r from Role r WHERE r.name= :name", Role.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findAny().orElse(null);
    }
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Role findByName(String name) {
//        try {
//            Role role = (Role) sessionFactory.getCurrentSession()
//                    .createQuery("from Role WHERE name= :name")
//                    .setParameter("name", name)
//                    .uniqueResult();
//            return role;
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            return null;
//        }
//    }
}
