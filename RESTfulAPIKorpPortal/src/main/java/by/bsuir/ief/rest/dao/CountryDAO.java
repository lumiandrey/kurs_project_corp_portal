package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Country;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CountryDAO {
    void create(Country createUser) throws Exception;
    List<Country> read() throws Exception;
    Country read(int id) throws Exception;
    void delete(int id) throws Exception;
    void update(Country person);
}
