package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;

import java.util.List;

/**
 * Created by andrey on 02.04.2016.
 */
public interface UserDAO {

    /**
     * Create Row to DataBase.
     *
     * @param createUser
     */
    User create(User createUser);

    /**
     * Read all rows.
     *
     * @return
     */
    List<User> read();

    /**
     * Read row by id.
     *
     * @param id uniqoe identification user to Base
     * @return
     */
    User read(int id) throws EntityNotFoundByIdException;

    /**
     *
     * @param login
     * @return
     * @throws Exception
     */
    User readLogin(String login) throws Exception;

    /**
     *
     * @param deleteUser
     * @return
     * @throws EntityNotFoundByIdException
     */
    boolean delete(User deleteUser) throws EntityNotFoundByIdException;

    /**
     *
     * @param updateUser
     * @return
     */
    User update(User updateUser);

    /**
     *
     * @param user
     * @return
     * @throws EntityNotFoundByParametrsException
     */
    User findByLoginPassword(User user) throws EntityNotFoundByParametrsException;;
}
