package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.User;

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
    void create(User createUser);

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
    User read(int id);

    void delete(User deleteUser);
}
