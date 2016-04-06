package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Repository
public class UserHibernate implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(User createUser) {
        currentSession().save(createUser);
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public void delete(User deleteUser) {

    }
}
