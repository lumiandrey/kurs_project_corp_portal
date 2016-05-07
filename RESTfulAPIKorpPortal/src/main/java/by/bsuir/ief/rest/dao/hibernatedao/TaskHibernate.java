package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.TaskDAO;
import by.bsuir.ief.rest.model.entity.Task;
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
 * Created by andrey on 26.04.2016.
 */
@Repository
@Transactional
public class TaskHibernate implements TaskDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_TASK = "from Task where id = :id_task";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Task create(Task task) throws Exception {
        getCurrentSession().save(task);
        return task;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Task> read() throws AllEntityNotFountException {
        List<Task> tasks = getCurrentSession().createCriteria(Task.class).list();
        if(tasks == null)
            throw new AllEntityNotFountException(Task.class.toString());
        return tasks;
    }

    @Override
    public List<Task> readTaskByIdPerson(int id) throws Exception {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Task read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TASK);
        query.setParameter("id_task", id);
        Task task = (Task) query.uniqueResult();
        if(task == null )
            throw new EntityNotFoundByIdException(id,Task.class.getName());
        return task;
    }

    @Override
    public Task update(Task task)throws Exception {
        getCurrentSession().update(task);
        return task;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TASK);
        query.setParameter("id_task", id);
        Task task = (Task) query.uniqueResult();
        if(task == null) {
            throw new EntityNotFoundByIdException(id, Task.class.getName());
        }
        session.delete(task);
    }
}
