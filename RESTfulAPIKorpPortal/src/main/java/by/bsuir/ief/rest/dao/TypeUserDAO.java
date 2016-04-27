package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.TypeUser;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface TypeUserDAO {
    /**
     *
     * @param typeUser
     * @throws Exception
     */
    TypeUser create(TypeUser typeUser) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<TypeUser> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    TypeUser read(int id) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     *
     * @param typeUser
     */
    void update(TypeUser typeUser);
}
