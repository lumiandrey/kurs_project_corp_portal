package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.TypeTaskDAO;
import by.bsuir.ief.rest.model.entity.TypeTask;
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
 * Created by Darya on 27.04.16.
 */
@Component
public class TypeTaskService {

    @Qualifier("typeTaskHibernate")
    @Autowired
    private TypeTaskDAO typeTaskHibernate;

    /**
     *
     * @param typeTask
     * @return
     * @throws BadAddEntityException
     */
    public TypeTask add(TypeTask typeTask) throws BadAddEntityException {
        try {
            typeTask = typeTaskHibernate.create(typeTask);
        } catch (Exception e) {
            throw new BadAddEntityException(TypeTask.class.toString(),e);
        }
        return typeTask;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public TypeTask read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        TypeTask person = null;
        try {
            person = typeTaskHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(TypeTask.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<TypeTask> read() throws AllEntityNotFountException, BadGetEntityException {
        List<TypeTask> list = null;
        try {
            list = typeTaskHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(TypeTask.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param person
     * @return
     * @throws BadUpdateException
     */
    public TypeTask update(TypeTask person) throws BadUpdateException {
        try {
            person = typeTaskHibernate.update(person);
        } catch (Exception e) {
            throw  new BadUpdateException(TypeTask.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            typeTaskHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),TypeTask.class.toString(),e);
        }
    }

}
