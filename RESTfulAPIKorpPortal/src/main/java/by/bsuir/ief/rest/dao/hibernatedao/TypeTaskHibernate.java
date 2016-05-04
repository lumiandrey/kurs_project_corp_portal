package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.TypeTaskDAO;
import by.bsuir.ief.rest.model.entity.TypeTask;
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
 * Created by andrey on 27.04.2016.
 */
@Repository
@Transactional
public class TypeTaskHibernate implements TypeTaskDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_TYPE_TASK = "from TypeTask where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public TypeTask create(TypeTask typeTask) throws Exception {
        getCurrentSession().save(typeTask);
        return typeTask;
    }

    @Override
    @Transactional(readOnly=true)
    public List<TypeTask> read() throws AllEntityNotFountException {
        List<TypeTask> tasks = getCurrentSession().createCriteria(TypeTask.class).list();
        if(tasks == null)
            throw new AllEntityNotFountException(TypeTask.class.toString());
        return tasks;
    }

    @Override
    @Transactional(readOnly=true)
    public TypeTask read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TYPE_TASK);
        query.setParameter("id", id);
        TypeTask typeTask = (TypeTask) query.uniqueResult();
        if(typeTask == null )
            throw new EntityNotFoundByIdException(id,TypeTask.class.getName());
        return typeTask;
    }

    @Override
    public TypeTask update(TypeTask typeTask) throws Exception {
        getCurrentSession().update(typeTask);
        return typeTask;
    }

    @Override
    public boolean delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TYPE_TASK);
        query.setParameter("id", id);
        TypeTask typeTask = (TypeTask) query.uniqueResult();
        if(typeTask == null) {
            throw new EntityNotFoundByIdException(id, TypeTask.class.getName());
        }
        session.delete(typeTask);
        return true;
    }
}
