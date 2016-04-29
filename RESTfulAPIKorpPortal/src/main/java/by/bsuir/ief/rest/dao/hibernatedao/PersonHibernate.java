package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.model.entity.PersonEntity;
import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    private final static String HQL_FIND_BY_ID = "from PersonEntity where id = :idPerson";

    @Override
    public PersonEntity create(PersonEntity createPerson) throws Exception{
        session = getCurrentSession();
        session.save(createPerson);
        return createPerson;
    }

    @Override
    @Transactional(readOnly=true)
    public List<PersonEntity> read() throws AllEntityNotFountException{
        session = getCurrentSession();
        List personList = session.createCriteria(PersonEntity.class).list();
        if(personList == null)
            throw new AllEntityNotFountException(PersonEntity.class.toString());
        return personList;
    }

    @Override
    @Transactional(readOnly=true)
    public PersonEntity read(int id) throws EntityNotFoundByIdException{
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID);
        query.setParameter("idPerson", id);
        PersonEntity person = (PersonEntity) query.uniqueResult();
        if(person ==null)
            throw new EntityNotFoundByIdException(id,PersonEntity.class.toString());
        return person;
    }


    @Override
    public PersonEntity update(PersonEntity person)throws Exception {
        session = getCurrentSession();
        session.update(person);
        return person;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Query query = getCurrentSession().createQuery(HQL_FIND_BY_ID);
        query.setParameter("idPerson", id);
        PersonEntity person = (PersonEntity) query.uniqueResult();
        if(person != null)
            session.delete(person);
        else
            throw new EntityNotFoundByIdException(id,PersonEntity.class.toString());

    }

    @Override
    public String toString() {
        return "PersonHibernate{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }

}
