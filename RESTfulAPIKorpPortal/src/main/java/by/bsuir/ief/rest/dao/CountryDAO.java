package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Country;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CountryDAO {
    /**
     *
     * @param country
     * @throws Exception
     */
    Country create(Country country) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Country> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Country read(int id) throws Exception;

    /**
     *
     * @param country
     */
    Country update(Country country) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    boolean delete(int id) throws Exception;


}
