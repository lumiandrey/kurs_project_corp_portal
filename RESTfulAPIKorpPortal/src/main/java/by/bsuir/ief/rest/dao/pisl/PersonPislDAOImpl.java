package by.bsuir.ief.rest.dao.pisl;

import by.bsuir.ief.rest.model.pisl.PersonPisl;
import by.bsuir.ief.rest.util.exception.UserNotFoundException;
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
    Transaction tx = null;

    private final String hqlfindByIdPerson = "from PersonPisl where id = :id";
    private final String hqldeleteAllPerson = "delete from PersonPisl";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public PersonPisl addEntity(PersonPisl personPisl) throws Exception {
        session = getCurrentSession();
        session.saveOrUpdate(personPisl);
        return personPisl;
    }

    @Override
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception {
        session =  getCurrentSession();

        for(PersonPisl personPisl:personPisls) {
            session.saveOrUpdate(personPisl);
        }
        return personPisls;
    }

    @Override
    public boolean updateEntity(PersonPisl personPisl) throws Exception {
        //session = sessionFactory.openSession();
        session = getCurrentSession();
        session.update(personPisl);
        return false;
    }

    @Override
    public boolean updateEntitys(List<PersonPisl> personPisls) throws Exception {
        session = getCurrentSession();
        for(PersonPisl personPisl:personPisls) {
            session.update(personPisl);
        }
        return false;
    }

    @Override
    @Transactional(readOnly=true)
    public PersonPisl getEntityById(int id) throws Exception {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        PersonPisl personPisl = (PersonPisl) query.uniqueResult();
        if(personPisl.getIdpersonPisl() == 0)
            new UserNotFoundException(id);
        return personPisl;
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
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdPerson);
        query.setParameter("id",new Integer(id));
        List<PersonPisl> pisls = query.list();
        PersonPisl personPisl = (pisls.size() >= 1? pisls.get(0):null);
        if(personPisl == null)
            new UserNotFoundException(id);
        session.delete(personPisl);
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
        return true;
    }
}
