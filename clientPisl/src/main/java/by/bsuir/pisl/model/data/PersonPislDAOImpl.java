package by.bsuir.pisl.model.data;

import by.bsuir.pisl.model.entity.PersonPisl;
import by.bsuir.pisl.model.except.notfoundexception.EntityNotFoundByIdException;
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
@Repository("personPislDAOImpl1")
public class PersonPislDAOImpl implements PersonPislDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    static final Logger logger = Logger.getLogger(PersonPislDAOImpl.class);

    private final String hqlfindByIdPerson = "from PersonPisl where id = :id";
    private final String hqldeleteAllPerson = "delete from PersonPisl";


    @Override
    public PersonPisl addEntity(PersonPisl personPisl) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(personPisl);
        tx.commit();
        session.close();
        logger.info("Add entity: "+personPisl);
        return personPisl;
    }

    @Override
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception {

        session = sessionFactory.openSession();

        for(PersonPisl o :personPisls) {
            tx = session.beginTransaction();
            session.save(o);
            logger.info("Add entity: "+o);
            tx.commit();
        }
        session.close();

        return personPisls;
    }

    @Override
    public List<PersonPisl> saveOrUpdates(List<PersonPisl> personPisls) throws Exception {
        session = sessionFactory.openSession();

        for(PersonPisl o :personPisls) {
            tx = session.beginTransaction();
            session.saveOrUpdate(o);
            logger.info("Add or Update entity: "+o);
            tx.commit();
        }
        session.close();

        return personPisls;
    }

    @Override
    public PersonPisl saveOrUpdates(PersonPisl personPisl) throws Exception
    {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(personPisl);
        tx.commit();
        session.close();
        logger.info("Add or Update entity: "+personPisl);

        return personPisl;
    }

    @Override
    public PersonPisl updateEntity(PersonPisl personPisl) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(personPisl);
        tx.commit();
        session.close();
        logger.info("Update entity: "+personPisl);

        return personPisl;
    }

    @Override
    public List<PersonPisl> updateEntitys(List<PersonPisl> personPisls) throws Exception {

        session = sessionFactory.openSession();
        for(PersonPisl user:personPisls) {
            tx = session.getTransaction();
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
        }
        session.close();
        return personPisls;
    }

    @Override
    @Transactional(readOnly=true)
    public PersonPisl getEntityById(int id) throws EntityNotFoundByIdException,Exception {

        session = sessionFactory.openSession();
        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        PersonPisl personPisl = (PersonPisl) query.uniqueResult();
        if(personPisl == null )
            throw new EntityNotFoundByIdException(id,PersonPisl.class.getName());
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        logger.info("Get by id: " +id + " entity: "+personPisl);
        return personPisl;

    }

    @Override
    @Transactional(readOnly=true)
    public List<PersonPisl> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<PersonPisl> userList = session.createCriteria(PersonPisl.class).list();
        tx.commit();
        session.close();
        return userList;


    }

    @Override
    public boolean deleteEntity(int id) throws EntityNotFoundByIdException,Exception {

        session = sessionFactory.openSession();

        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        PersonPisl pisls = (PersonPisl) query.uniqueResult();
        if(pisls == null) {
            throw new EntityNotFoundByIdException(id, PersonPisl.class.getName());
        }

        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(pisls);
        tx.commit();
        return true;
    }

    @Override
    public boolean deleteEntity(PersonPisl personPisl)throws Exception
    {
        session = sessionFactory.openSession();
        session.delete(personPisl);

        return true;
    }

    @Override
    public boolean deleteAllEntity() throws Exception {

        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery(hqldeleteAllPerson).executeUpdate();
        tx.commit();
        logger.info("Delete  all Entitys");
        return true;
    }
}
