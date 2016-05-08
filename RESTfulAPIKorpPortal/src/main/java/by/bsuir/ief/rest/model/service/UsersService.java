package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.UserDAO;
import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Андрей on 07.04.2016.
 */
@Component
public class UsersService {

    @Autowired
    @Qualifier("userHibernate")
    private UserDAO userHibernate;


    public UserDAO getUserHibernate() {
        return userHibernate;
    }

    public void setUserHibernate(UserDAO userHibernate) {
        this.userHibernate = userHibernate;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public User read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        User person = null;
        try {
            person = userHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(User.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<User> read() throws AllEntityNotFountException, BadGetEntityException {
        List<User> list = null;
        try {
            list = userHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(User.class.toString(),e);
        }
        return list;
    }


    public User readByIdPerson(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        User user = null;
        try {
            user = userHibernate.readByIdPerson(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(User.class.getName(),e);
        }
        return user;
    }

    /**
     *
     * @param login
     * @return
     * @throws EntityNotFoundByParametrsException
     * @throws BadGetEntityException
     */
    public User getUserByLogin(String login) throws EntityNotFoundByParametrsException, BadGetEntityException {
        User user = null;
        try {
            user = userHibernate.readLogin(login);
        } catch (EntityNotFoundByParametrsException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(User.class.toString(),e);
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     * @throws EntityNotFoundByParametrsException
     * @throws BadGetEntityException
     */
    public User autorizen(User user) throws EntityNotFoundByParametrsException, BadGetEntityException {
        try {
            user = userHibernate.findByLoginPassword(user);
        } catch (EntityNotFoundByParametrsException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(User.class.toString(),e);
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     * @throws BadAddEntityException
     */
    public User registration(User user) throws BadAddEntityException {
        try {
            return userHibernate.create(user);
        } catch (Exception e) {
            throw new BadAddEntityException(User.class.toString(),e);
        }
    }

    public User add(User person) throws BadAddEntityException {
        try {
            person = userHibernate.create(person);
        } catch (Exception e) {
            throw new BadAddEntityException(User.class.toString(),e);
        }
        return person;
    }


    /**
     *
     * @param person
     * @return
     * @throws BadUpdateException
     */
    public User update(User person) throws BadUpdateException {
        try {
            person = userHibernate.update(person);
        } catch (Exception e) {
            throw  new BadUpdateException(User.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public boolean delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            userHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),User.class.toString(),e);
        }
        return true;
    }

    public boolean delete(String login) throws EntityNotFoundByParametrsException, BadDeleteEntityException {
        try {
            userHibernate.delete(login);
        } catch (EntityNotFoundByParametrsException e) {
            throw e;
        } catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),User.class.toString(),e);
        }
        return true;
    }

}
