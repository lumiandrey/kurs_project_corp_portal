package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.entity.Person;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
public interface PersonDAO {
    void create(Person createUser);
    List<Person> readAll();
    Person read(int id);
    void delete(Person deleteUser);
}
