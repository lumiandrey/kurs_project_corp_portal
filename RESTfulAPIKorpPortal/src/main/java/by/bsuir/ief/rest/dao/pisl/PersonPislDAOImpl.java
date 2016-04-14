package by.bsuir.ief.rest.dao.pisl;

import by.bsuir.ief.rest.model.pisl.PersonPisl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@Transactional
@Repository("personPislDAOImpl1")
public class PersonPislDAOImpl implements PersonPislDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public PersonPisl addEntity(PersonPisl personPisl) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        //tx = session.beginTransaction();
        session.saveOrUpdate(personPisl);
       // tx.commit();
        //session.close();
        return personPisl;
    }

    @Override
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception {
        //session = sessionFactory.openSession();
        session =  getCurrentSession();

        for(PersonPisl personPisl:personPisls) {
            //tx = session.beginTransaction();
            session.saveOrUpdate(personPisl);
            //tx.commit();
        }
       // session.close();
        return personPisls;
    }

    @Override
    public boolean updateEntity(PersonPisl personPisl) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        PersonPisl personPisl1;
        personPisl = (PersonPisl) session.load(PersonPisl.class, personPisl.getIdpersonPisl());
        //tx = session.getTransaction();
        personPisl1 = personPisl;
        //tx = session.beginTransaction();
        session.saveOrUpdate(personPisl1);
        //tx.commit();
        //session.close();
        return false;
    }

    @Override
    public boolean updateEntitys(List<PersonPisl> personPisls) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        for(PersonPisl personPisl:personPisls) {
            PersonPisl personPisl1;
            personPisl1 = (PersonPisl) session.load(PersonPisl.class, personPisl.getIdpersonPisl());
            tx = session.getTransaction();
            personPisl1 = personPisl;
            tx = session.beginTransaction();
            session.saveOrUpdate(personPisl1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    @Transactional(readOnly=true)
    public PersonPisl getEntityById(int id) throws Exception {
        session = getCurrentSession();
        PersonPisl user = (PersonPisl) session.load(PersonPisl.class, id);
        return user;
    }

    @Override
    @Transactional(readOnly=true)
    public List<PersonPisl> getEntityList() throws Exception {
        session = getCurrentSession();
        List<PersonPisl> userList = session.createCriteria(PersonPisl.class).list();
        return userList;
    }

    @Override
    public boolean deleteEntity(int id) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        PersonPisl personPisl = session.load(PersonPisl.class, id);
        //tx = session.getTransaction();
        //session.beginTransaction();
        session.delete(personPisl);
        //tx.commit();
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
       // session = sessionFactory.openSession();
        session = getCurrentSession();
        //tx = session.getTransaction();
       // session.beginTransaction();
        session.createQuery("DELETE FROM PersonPisl").executeUpdate();
        //tx.commit();
        return true;
    }
}
