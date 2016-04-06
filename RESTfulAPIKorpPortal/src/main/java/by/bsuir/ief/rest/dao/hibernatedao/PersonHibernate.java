package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Repository
public class PersonHibernate implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public PersonHibernate() {
    }

    @Override
    public void create(Person createUser) {

    }

    @Override
    public List<Person> readAll() {
        return null;
    }

    @Override
    public Person read(int id) {
        return null;
    }

    @Override
    public void delete(Person deleteUser) {

    }


}
