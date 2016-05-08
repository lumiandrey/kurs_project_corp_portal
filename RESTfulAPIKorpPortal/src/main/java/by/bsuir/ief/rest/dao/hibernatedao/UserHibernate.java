package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Transactional
@Repository
public class UserHibernate implements UserDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public UserHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;

    private final String HQL_FIND_LOGIN_PASSWORD = "from User where login = :login and password = :password";
    private final String HQL_FIND_BY_ID = "from User where id = :idUser";
    private final String HQL_FIND_BY_ID_PERSON = "from User where person.idPerson = :idPerson";
    private final String HQL_FIND_BY_LOGIN = "from User where login = :login";



    public UserHibernate() {
    }

    public Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     * @param createUser
     * @return
     * @throws Exception
     */
    @Override
    public User create(User createUser) throws Exception{
        getCurrentSession().save(createUser);
        return createUser;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     */
    @Override
    public List<User> read() throws AllEntityNotFountException {

        List<User> userList = getCurrentSession().createCriteria(User.class).list();
        if(userList == null)
            throw new AllEntityNotFountException(User.class.toString());
        return userList;
    }

    /**
     *
     * @param id uniqoe identification user to Base
     * @return
     * @throws EntityNotFoundByIdException
     */
    @Override
    public User read(int id) throws EntityNotFoundByIdException {

        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID);
        query.setParameter("idUser", id);
        User user1 = (User) query.uniqueResult();
        if(user1 == null )
            throw new EntityNotFoundByIdException(id,User.class.getName());
        return user1;
    }

    /**
     *
     * @param user
     * @return
     * @throws EntityNotFoundByParametrsException
     */
    @Override
    public User findByLoginPassword(User user) throws EntityNotFoundByParametrsException {
        Query query = getCurrentSession().createQuery(HQL_FIND_LOGIN_PASSWORD);
        query.setParameter("login",user.getLogin())
                .setParameter("password",user.getPassword());
        User user1 = (User) query.uniqueResult();
        if(user1 == null)
            throw new EntityNotFoundByParametrsException("No result", user.getLogin(),user.getPassword());
        return user1;
    }

    @Override
    public User readByIdPerson(int id) throws Exception {
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID_PERSON);
        query.setParameter("idPerson", id);
        User user1 = (User) query.uniqueResult();
        if(user1 == null )
            throw new EntityNotFoundByIdException(id,User.class.getName());
        return user1;
    }

    /**
     *
     * @param login
     * @return
     * @throws EntityNotFoundByParametrsException
     */
    @Override
    public User readLogin(String login) throws EntityNotFoundByParametrsException {
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_LOGIN);
        query.setParameter("login",login);
        User user1 = (User) query.uniqueResult();
        if(user1 == null)
            throw new EntityNotFoundByParametrsException("No result", login);
        return user1;
    }

    /**
     *
     * @param updateUser
     * @return
     * @throws Exception
     */
    @Override
    public User update(User updateUser) throws Exception {
        getCurrentSession().update(updateUser);
        return updateUser;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "UserHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     */
    @Override
    public boolean delete(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID);
        query.setParameter("idUser",new Integer(id));
        User user = (User) query.uniqueResult();
        if(user == null) {
            throw new EntityNotFoundByIdException(id, User.class.getName());
        }
        session.delete(user);
        return true;
    }

    @Override
    public boolean delete(String login) throws EntityNotFoundByParametrsException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_LOGIN);
        query.setParameter("login",login);
        User user = (User) query.uniqueResult();
        if(user == null) {
            throw new EntityNotFoundByParametrsException(login, User.class.getName());
        }
        session.delete(user);
        return true;
    }

    /**
     *
     * @param deleteUser
     * @return
     * @throws EntityNotFoundByIdException
     */
    @Override
    public boolean delete(User deleteUser) throws EntityNotFoundByIdException {
        getCurrentSession().delete(deleteUser);
        return true;
    }
}
