package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.model.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    Session session = null;
    Transaction tx = null;

    public PersonHibernate() {
    }

    @Override
    public void create(Person createUser) throws Exception{
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(createUser);
        tx.commit();
        session.close();
    }

    @Override
    public List<Person> readAll() throws Exception{

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Person> personList = session.createCriteria(Person.class).list();
        tx.commit();
        session.close();
        return personList;
    }

    @Override
    public Person read(int id) throws Exception {
        session = sessionFactory.openSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return person;
    }

    @Override
    public void delete(int id) throws Exception{
        session = sessionFactory.openSession();
        Object o = session.load(Person.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();

    }

    @Override
    public void update(Person person) {
        session = sessionFactory.openSession();
        Person person1;
        person1 = (Person) session.load(Person.class, person.getIdPerson());
        tx = session.getTransaction();
        person1 = person;
        tx = session.beginTransaction();
        session.saveOrUpdate(person1);
        tx.commit();
        session.close();
    }

    @Override
    public String toString() {
        return "PersonHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

}
