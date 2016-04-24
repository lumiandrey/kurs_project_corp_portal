package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.model.entity.Person;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Repository
@Transactional
public class PersonHibernate implements PersonDAO {

    static final Logger logger = Logger.getLogger(PersonHibernate.class);

    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    public PersonHibernate() {
    }

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Person create(Person createPerson) throws Exception{
        //session = sessionFactory.openSession();
        session = getCurrentSession();
       // tx = session.beginTransaction();
        session.save(createPerson);
        //tx.commit();
        logger.info("Add entity to db: "+createPerson);
        //session.close();
        return createPerson;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Person> read() throws Exception{
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        //tx = session.beginTransaction();
        List personList = session.createCriteria(Person.class).list();
        //tx.commit();
        //session.close();
        logger.info("Get entitys[" + Person.class + "]from db:");
        return personList;
    }

    @Override
    @Transactional(readOnly=true)
    public Person read(int id) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        //tx = session.getTransaction();
        //session.beginTransaction();
       // tx.commit();
        logger.info("Get by id: " +id + " entity: "+person);
        return person;
    }


    @Override
    public Person update(Person person) {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        //Person person1 = session.load(Person.class, person.getIdPerson());
        //tx = session.getTransaction();
        //person1 = person;
        //tx = session.beginTransaction();
        session.saveOrUpdate(person);
        logger.info("Update entity: "+person);
        //tx.commit();
        //session.close();
        return person;
    }

    @Override
    public void delete(int id) throws Exception{
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        Person o = session.load(Person.class, id);
        //tx = session.getTransaction();
        //session.beginTransaction();
        session.delete(o);
        //tx.commit();

    }

    @Override
    public String toString() {
        return "PersonHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

}
