package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Андрей on 07.04.2016.
 */
@Component
public class UsersService {


    @Qualifier("userHibernate")
    @Autowired
    private UserDAO userHibernate;

    public User autorizen(User user) throws EntityNotFoundByParametrsException {
        user = userHibernate.findByLoginPassword(user);
        return user;
    }

    public User registration(User user)throws Exception{
        return userHibernate.create(user);
    }

    public User getUserByLogin(String login)
    {
        return null;
    }

}
