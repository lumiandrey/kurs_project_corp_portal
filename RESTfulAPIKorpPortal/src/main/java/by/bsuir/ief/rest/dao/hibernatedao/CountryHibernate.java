package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.CountryDAO;
import by.bsuir.ief.rest.model.entity.Country;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 25.04.2016.
 */
@Repository
@Transactional
public class CountryHibernate implements CountryDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_COUNTRY = "from Country where idCountryt = :idCountryt";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Country create(Country country) throws Exception {
        getCurrentSession().save(country);
        return country;
    }

    @Override
    public List<Country> read() throws Exception {
        List<Country> countries = getCurrentSession().createCriteria(Country.class).list();
        return countries;
    }

    @Override
    public Country read(int id) throws Exception {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_COUNTRY);
        query.setParameter("idCountryt", id);
        Country country = (Country) query.uniqueResult();
        if(country == null )
            throw new EntityNotFoundByIdException(id,Country.class.getName());
        return country;
    }

    @Override
    public Country update(Country country) throws Exception {
        getCurrentSession().update(country);
        return country;
    }

    @Override
    public void delete(int id) throws Exception {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_COUNTRY);
        query.setParameter("idCountryt", id);
        Country country = (Country) query.uniqueResult();
        if(country == null )
            throw new EntityNotFoundByIdException(id,Country.class.getName());
        session.delete(country);
    }
}
