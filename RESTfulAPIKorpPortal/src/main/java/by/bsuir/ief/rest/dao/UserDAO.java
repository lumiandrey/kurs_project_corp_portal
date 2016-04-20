package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;

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
    List<User> readAll();

    /**
     * Read row by id.
     *
     * @param id uniqoe identification user to Base
     * @return
     */
    User read(int id) throws EntityNotFoundByIdException;

    boolean delete(User deleteUser) throws EntityNotFoundByIdException;

    User update(User updateUser);
}
