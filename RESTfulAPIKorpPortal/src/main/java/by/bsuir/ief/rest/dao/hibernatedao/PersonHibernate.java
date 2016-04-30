package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.model.entity.Person;
import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * Created by andrey on 05.04.2016.
 */
@Repository("personHibernate")
@Transactional
public class PersonHibernate implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;

    public PersonHibernate() {
    }

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    private final static String HQL_FIND_BY_ID = "from Person where id = :idPerson";

    @Override
    public Person create(Person createPerson) throws Exception{
        session = getCurrentSession();
        session.save(createPerson);
        return createPerson;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Person> read() throws AllEntityNotFountException{
        session = getCurrentSession();
        List personList = session.createCriteria(Person.class).list();
        if(personList == null)
            throw new AllEntityNotFountException(Person.class.toString());
        return personList;
    }

    @Override
    @Transactional(readOnly=true)
    public Person read(int id) throws EntityNotFoundByIdException{
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID);
        query.setParameter("idPerson", id);
        Person person = (Person) query.uniqueResult();
        if(person ==null)
            throw new EntityNotFoundByIdException(id,Person.class.toString());
        return person;
    }


    @Override
    public Person update(Person person)throws Exception {
        session = getCurrentSession();
        session.update(person);
        return person;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID);
        query.setParameter("idPerson", id);
        Person person = (Person) query.uniqueResult();
        if(person != null)
            session.delete(person);
        else
            throw new EntityNotFoundByIdException(id,Person.class.toString());

    }

    @Override
    public String toString() {
        return "PersonHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

}
