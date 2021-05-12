package Dao;

import Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return (List<User>) entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getUser(int id) {
        return  this.entityManager.find(User.class,id);
    }

    @Override
    public void removeUser(int id) {
        User user = entityManager.find(User.class,id);
        System.out.println(user);
        entityManager.remove(user);
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
}
