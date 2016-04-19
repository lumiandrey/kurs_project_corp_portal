package by.bsuir.ief.rest.dao.pisl;

import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.pisl.PersonPisl;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@SuppressWarnings("ALL")
@Transactional
@Repository("personPislDAOImpl1")
public class PersonPislDAOImpl implements PersonPislDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    //Transaction tx = null;
//
    static final Logger logger = Logger.getLogger(PersonPislDAOImpl.class);

    private final String hqlfindByIdPerson = "from PersonPisl where id = :id";
    private final String hqldeleteAllPerson = "delete from PersonPisl";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public PersonPisl addEntity(PersonPisl personPisl) throws Exception {
        session = getCurrentSession();
        session.save(personPisl);
        logger.info("Add entity: "+personPisl);
        return personPisl;
    }

    @Override
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception {
        session =  getCurrentSession();

        for(PersonPisl personPisl:personPisls) {
            session.save(personPisl);
            logger.info("Add entity: "+personPisl);
        }
        return personPisls;
    }

    @Override
    public PersonPisl updateEntity(PersonPisl personPisl) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        session.update(personPisl);
        logger.info("Update entity: "+personPisl);
        return personPisl;
    }

    @Override
    public List<PersonPisl> updateEntitys(List<PersonPisl> personPisls) throws Exception {
        session = getCurrentSession();
        for(PersonPisl personPisl:personPisls) {
            session.update(personPisl);
            logger.info("Update entity: "+personPisl);
        }
        return personPisls;
    }

    @Override
    @Transactional(readOnly=true)
    public PersonPisl getEntityById(int id) throws EntityNotFoundByIdException,Exception {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        PersonPisl personPisl = (PersonPisl) query.uniqueResult();
        if(personPisl == null )
            throw new EntityNotFoundByIdException(id,PersonPisl.class.getName());
        logger.info("Get by id: " +id + " entity: "+personPisl);
        return personPisl;
    }

    @Override
    @Transactional(readOnly=true)
    public List<PersonPisl> getEntityList() throws Exception {
        session = getCurrentSession();
        List<PersonPisl> userList = session.createCriteria(PersonPisl.class).list();
        logger.info("Get entitys");
        return userList;
    }

    @Override
    public boolean deleteEntity(int id) throws EntityNotFoundByIdException,Exception {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        PersonPisl pisls = (PersonPisl) query.uniqueResult();
        if(pisls == null) {
            throw new EntityNotFoundByIdException(id, PersonPisl.class.getName());
        }
        logger.info("Delete by id: " +id+" entity: " + pisls);
        session.delete(pisls);
        return true;
    }

    @Override
    public boolean deleteEntity(PersonPisl personPisl)throws Exception
    {
        session = getCurrentSession();
        session.delete(personPisl);

        return true;
    }

    @Override
    public boolean deleteAllEntity() throws Exception {
        session = getCurrentSession();
        session.createQuery(hqldeleteAllPerson).executeUpdate();
        logger.info("Delete  all Entitys");
        return true;
    }
}
