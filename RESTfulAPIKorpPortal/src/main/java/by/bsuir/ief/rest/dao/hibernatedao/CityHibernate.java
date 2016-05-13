package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.CityDAO;
import by.bsuir.ief.rest.model.entity.City;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
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
public class CityHibernate implements CityDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;

    private final String HQL_FIND_BY_ID_CITY = "from City where idCity = :idCity";
    private final String HQL_SELECT_ALL_CITY_BY_COUNTRY = "from City where country.id = :id_country";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public City create(City city) throws Exception {
        getCurrentSession().save(city);
        return city;
    }

    @Override
    @Transactional(readOnly=true)
    public List<City> read() throws AllEntityNotFountException {
        List<City> cities = getCurrentSession().createCriteria(City.class).list();
        if(cities == null)
            throw new AllEntityNotFountException(City.class.toString());
        return cities;
    }

    @Override
    @Transactional(readOnly=true)
    public City read(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_CITY);
        query.setParameter("idCity", id);
        City city = (City) query.uniqueResult();
        if(city == null )
            throw new EntityNotFoundByIdException(id,City.class.getName());
        return city;
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> readCityByIdCountry(int idCountry) throws AllEntityNotFountException
    {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_SELECT_ALL_CITY_BY_COUNTRY);
        query.setParameter("id_country", idCountry);
        List<City> list = (List<City>)query.list();
        if(list == null)
            throw new AllEntityNotFountException(City.class.toString());
        return list;
    }

    @Override
    public City update(City city) throws Exception {
        session = getCurrentSession();
        session.update(city);
        return city;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_CITY);
        query.setParameter("idCity", id);
        City city = (City) query.uniqueResult();
        if(city == null) {
            throw new EntityNotFoundByIdException(id, City.class.getName());
        }
        session.delete(city);
    }


}
