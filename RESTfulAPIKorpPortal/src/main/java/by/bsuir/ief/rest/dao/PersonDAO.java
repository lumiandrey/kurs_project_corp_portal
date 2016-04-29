package by.bsuir.ief.rest.dao;


import by.bsuir.ief.rest.model.entity.PersonEntity;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
public interface PersonDAO {
    /**
     *
     * @param createPerson
     * @return
     * @throws Exception
     */
    PersonEntity create(PersonEntity createPerson) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    PersonEntity read(int id) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     *
     * @param person
     * @return
     * @throws Exception
     */
    PersonEntity update(PersonEntity person) throws Exception;
}
