package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.TaskDAO;
import by.bsuir.ief.rest.dao.mysql.TaskDaoMySql;
import by.bsuir.ief.rest.model.entity.Task;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
public class TaskService {

    @Qualifier("taskHibernate")
    @Autowired
    private TaskDAO taskHibernate;

    @Qualifier("taskDaoMySql")
    @Autowired
    private TaskDAO daoMySql;


    public Task addTaskByPerson(Task task, int idPerson) throws BadAddEntityException {
        int flag = 0;
        try{
            task = taskHibernate.create(task);
            flag = daoMySql.createHasTaskPerson(task.getId_task(),idPerson);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadAddEntityException(Task.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @param task
     * @return
     * @throws BadAddEntityException
     */
    public Task add(Task task) throws BadAddEntityException {
        try {
            task = taskHibernate.create(task);
        } catch (Exception e) {
            throw new BadAddEntityException(Task.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Task read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Task task = null;
        try {
            task = taskHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Task.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Task> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Task> list = null;
        try {
            list = taskHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Task.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param task
     * @return
     * @throws BadUpdateException
     */
    public Task update(Task task) throws BadUpdateException {
        try {
            task = taskHibernate.update(task);
        } catch (Exception e) {
            throw  new BadUpdateException(Task.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            taskHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Task.class.toString(),e);
        }
    }

    public List getTaskByIdPerson(int id) throws Exception {
        return daoMySql.readTaskByIdPerson(id);
    }
}
