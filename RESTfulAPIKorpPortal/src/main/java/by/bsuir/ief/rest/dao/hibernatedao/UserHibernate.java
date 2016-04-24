package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Transactional
@Repository("userHibernate")
public class UserHibernate implements UserDAO {

    static final Logger logger = Logger.getLogger(UserHibernate.class);

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    Session session = null;

    private final String hqlFindByLoginPassword = "from User where login = :login and password = :password";
    private final String hqlfindByIdUser = "from User where idUser = :idUser";
    private final String hqlfindByIdLogin = "from User where login = :login";

    public UserHibernate() {
    }

    public Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User create(User createUser) {
        getCurrentSession().save(createUser);
        logger.info("Add entity to db: "+createUser);
        return createUser;
    }

    @Override
    public List<User> read() {

        List<User> userList = getCurrentSession().createCriteria(User.class).list();
        logger.info("Get entitys[" + User.class + "]from db:");
        return userList;
    }


    @Override
    public User read(int id) throws EntityNotFoundByIdException {

        Query query = getCurrentSession().createQuery(hqlfindByIdUser);
        query.setParameter("idUser",new Integer(id));
        User getUser = (User) query.uniqueResult();
        if(getUser == null )
            throw new EntityNotFoundByIdException(id,User.class.getName());
        logger.info("Get by id: " +id + " entity: "+getUser);
        return getUser;
    }




    @Override
    public User findByLoginPassword(User user) throws EntityNotFoundByParametrsException {
        Query query = getCurrentSession().createQuery(hqlFindByLoginPassword);
        query.setParameter("login",user.getLogin())
                .setParameter("password",user.getPassword());
        User user1 = (User) query.uniqueResult();
        if(user1 == null)
            throw new EntityNotFoundByParametrsException("No result", user.getLogin(),user.getPassword());
        logger.info("Get by login : " +user.getLogin() + " entity: "+user1);
        return user1;
    }

    @Override
    public User readLogin(String login) throws Exception {
        Query query = getCurrentSession().createQuery(hqlfindByIdLogin);
        query.setParameter("login",login);
        User user1 = (User) query.uniqueResult();
        logger.info("Get by login : " +login + " entity: "+user1);
        if(user1 == null)
            throw new EntityNotFoundByParametrsException("No result", login);
        return user1;
    }

    @Override
    public User update(User updateUser) {
        getCurrentSession().update(updateUser);
        logger.info("Update entity: "+updateUser);
        return updateUser;
    }

    @Override
    public String toString() {
        return "UserHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    @Override
    public boolean delete(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdUser);
        query.setParameter("idUser",new Integer(id));
        User pisls = (User) query.uniqueResult();
        if(pisls == null) {
            throw new EntityNotFoundByIdException(id, User.class.getName());
        }
        logger.info("Delete by id: " +id+" entity: " + pisls);
        session.delete(pisls);
        return true;
    }

    @Override
    public boolean delete(User deleteUser) throws EntityNotFoundByIdException {
        logger.info("Delete from db by id: " +deleteUser.getIdUser()+" entity: " + deleteUser);
        getCurrentSession().delete(deleteUser);
        return true;
    }
}
