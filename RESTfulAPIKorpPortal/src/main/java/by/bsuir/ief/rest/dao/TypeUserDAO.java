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
     * @param typeUser
     * @return
     * @throws Exception
     */
    TypeUser update(TypeUser typeUser)throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    boolean delete(int id) throws Exception;

}
