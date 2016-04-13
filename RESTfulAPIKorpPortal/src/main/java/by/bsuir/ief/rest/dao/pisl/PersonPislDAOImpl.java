package by.bsuir.ief.rest.dao.pisl;

import by.bsuir.ief.rest.model.pisl.PersonPisl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public PersonPisl addEntity(PersonPisl personPisl) throws Exception {
        getCurrentSession().saveOrUpdate(personPisl);
        return personPisl;
    }

    @Override
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception {
        return null;
    }

    @Override
    public boolean updateEntity(PersonPisl personPisl) throws Exception {
        return false;
    }

    @Override
    public boolean updateEntitys(List<PersonPisl> personPisls) throws Exception {
        return false;
    }

    @Override
    public PersonPisl getEntityById(int id) throws Exception {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<PersonPisl> getEntityList() throws Exception {
        return getCurrentSession().createQuery("from PersonPisl с").list();
    }

    @Override
    public boolean deleteEntity(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllEntity() throws Exception {
        return false;
    }
}
