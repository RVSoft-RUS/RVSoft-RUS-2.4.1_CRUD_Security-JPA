package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDaoImp implements UserDao {//
//   @Autowired
//   private SessionFactory sessionFactory;

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;
//
////   entityManagerFactory = Persistence.createEntityManagerFactory
////
//   @Autowired
//   public void setSessionFactory(EntityManager entityManager) {
//      this.entityManager = entityManager;
//   }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional("jpaTrans")
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u WHERE u.id= :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u WHERE u.login= :login", User.class);
        query.setParameter("login", login);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public boolean isExistLogin(String login) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u WHERE u.login= :login", User.class);
        query.setParameter("login", login);
        return query.getResultList().stream().findAny().orElse(null) != null;
    }

    public List<User> findAll() {
        return null;
    }
}
