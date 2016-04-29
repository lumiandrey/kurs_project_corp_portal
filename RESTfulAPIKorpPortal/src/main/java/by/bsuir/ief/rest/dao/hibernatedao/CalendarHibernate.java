package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.CalendarDAO;
import by.bsuir.ief.rest.model.entity.Calendar;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
@Transactional
public class CalendarHibernate implements CalendarDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_CALENDAR = "from Calendar where id = :idCity";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Calendar create(Calendar calendar) throws Exception {
        getCurrentSession().save(calendar);
        return calendar;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Calendar> read() throws Exception {
        List<Calendar> list = getCurrentSession().createCriteria(Calendar.class).list();
        if(list == null)
            throw new AllEntityNotFountException(Calendar.class.toString());
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Calendar read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_CALENDAR);
        query.setParameter("idCity", id);
        Calendar calendar = (Calendar) query.uniqueResult();
        if(calendar == null )
            throw new EntityNotFoundByIdException(id,Calendar.class.getName());
        return calendar;
    }

    @Override
    public Calendar update(Calendar calendar) throws Exception {
        Session session = getCurrentSession();
        session.update(calendar);
        return calendar;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_CALENDAR);
        query.setParameter("idCity", id);
        Calendar calendar = (Calendar) query.uniqueResult();
        if(calendar == null) {
            throw new EntityNotFoundByIdException(id, Calendar.class.getName());
        }
        session.delete(calendar);
    }
}
