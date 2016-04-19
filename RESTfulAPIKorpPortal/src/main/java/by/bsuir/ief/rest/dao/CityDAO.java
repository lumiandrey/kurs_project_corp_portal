package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.City;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CityDAO {
    void create(City createUser) throws Exception;
    List<City> readAll() throws Exception;
    City read(int id) throws Exception;
    void delete(int id) throws Exception;
    void update(City person);
}
