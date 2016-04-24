package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Person;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
public interface PersonDAO {
    Person create(Person createPerson) throws Exception;
    List read() throws Exception;
    Person read(int id) throws Exception;
    void delete(int id) throws Exception;
    Person update(Person person);
}
