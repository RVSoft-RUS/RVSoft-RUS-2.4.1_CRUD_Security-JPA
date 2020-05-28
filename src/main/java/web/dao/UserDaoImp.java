package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getAllUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void deleteUser(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }

   @Override
   public User getUserById(long id) {
//      return (User) sessionFactory.getCurrentSession().byId(String.valueOf(id));
      User user = (User) sessionFactory.getCurrentSession().createQuery("from User WHERE id= :id")
              .setParameter("id", id)
              .uniqueResult();
      return user;
   }

   @Override
   public void updateUser(User user) {
      sessionFactory.getCurrentSession().update(user);
   }

   @Override
   public User getUserByLogin(String login) {
      //if NULL ?????????????
      User user = (User) sessionFactory.getCurrentSession()
              .createQuery("from User WHERE login= :login")
              .setParameter("login", login)
              .uniqueResult();
      return user;
   }

   @Override
   public boolean isExistLogin(String login) {
      User user = (User) sessionFactory.getCurrentSession()
              .createQuery("from User WHERE login= :login")
              .setParameter("login", login)
              .uniqueResult();
      return user != null;
   }
}
