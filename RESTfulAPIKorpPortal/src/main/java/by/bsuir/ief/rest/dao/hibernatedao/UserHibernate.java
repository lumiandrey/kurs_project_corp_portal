package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.dao.pisl.PersonPislDAOImpl;
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


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;



    public UserHibernate() {
    }

    public Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    private final String hqlFindByLoginPassword = "from User where login = :login and password = :password";
    private final String hqlfindByIdUser = "from User where idUser = :idUser";
    static final Logger logger = Logger.getLogger(PersonPislDAOImpl.class);

    @Override
    public User create(User createUser) {
        currentSession().save(createUser);
        logger.info("Add entity to db: "+createUser);
        return createUser;
    }

    @Override
    public List<User> readAll() {

        List<User> userList = currentSession().createCriteria(User.class).list();
        logger.info("Get entitys from db:" + userList);
        return userList;
    }


    @Override
    public User read(int id) throws EntityNotFoundByIdException {

        Query query = currentSession().createQuery(hqlfindByIdUser);
        query.setParameter("idUser",new Integer(id));
        User getUser = (User) query.uniqueResult();
        if(getUser == null )
            throw new EntityNotFoundByIdException(id,User.class.getName());
        logger.info("Get by id: " +id + " entity: "+getUser);
        return getUser;
    }


    @Override
    public boolean delete(User deleteUser) throws EntityNotFoundByIdException {
        Query query = currentSession().createQuery(hqlfindByIdUser);
        query.setParameter("idUser",new Integer(deleteUser.getIdUser()));
        User pisls = (User) query.uniqueResult();
        if(pisls == null) {
            throw new EntityNotFoundByIdException(deleteUser.getIdUser(), User.class.getName());
        }
        logger.info("Delete from db by id: " +deleteUser.getIdUser()+" entity: " + pisls);
        currentSession().delete(pisls);
        return true;
    }

    @Override
    public User findByLiginPassword(User user) throws EntityNotFoundByIdException, EntityNotFoundByParametrsException {
        Query query = currentSession().createQuery(hqlFindByLoginPassword);
        query.setParameter("login",user.getLogin())
                .setParameter("password",user.getPassword());
        User user1 = (User) query.uniqueResult();
        if(user1 == null)
            throw new EntityNotFoundByParametrsException("No result", user.getLogin(),user.getPassword());
        return user1;
    }

    @Override
    public User update(User updateUser) {
        currentSession().update(updateUser);
        logger.info("Update entity: "+updateUser);
        return updateUser;
    }

    @Override
    public String toString() {
        return "UserHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }
}
