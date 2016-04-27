package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.City;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CityDAO {
    /**
     *
     * @param city
     * @throws Exception
     */
    City create(City city) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<City> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    City read(int id) throws Exception;

    /**
     *
     * @param person
     */
    City update(City person) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


}
