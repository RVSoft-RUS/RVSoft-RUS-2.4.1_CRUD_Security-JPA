package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {//

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u WHERE u.id= :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u WHERE u.login= :login", User.class);
        query.setParameter("login", login);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
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
