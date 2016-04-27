package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.RecordDAO;
import by.bsuir.ief.rest.model.entity.Record;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
public class RecordHibernate implements RecordDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_RECORD = "from Record where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Record create(Record record) throws Exception {
        getCurrentSession().save(record);
        return record;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Record> read() throws AllEntityNotFountException {
        List<Record> records = getCurrentSession().createCriteria(Record.class).list();
        if(records == null)
            throw new AllEntityNotFountException(Record.class.toString());
        return records;
    }

    @Override
    @Transactional(readOnly=true)
    public Record read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_RECORD);
        query.setParameter("id", id);
        Record record = (Record) query.uniqueResult();
        if(record == null )
            throw new EntityNotFoundByIdException(id,Record.class.getName());
        return record;
    }

    @Override
    public Record update(Record post) throws Exception {
        getCurrentSession().update(post);
        return post;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_RECORD);
        query.setParameter("id", id);
        Record record = (Record) query.uniqueResult();
        if(record == null) {
            throw new EntityNotFoundByIdException(id, Record.class.getName());
        }
        session.delete(record);
    }
}
