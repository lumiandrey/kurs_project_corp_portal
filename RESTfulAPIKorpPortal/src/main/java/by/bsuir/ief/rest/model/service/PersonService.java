package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.PersonDAO;
import by.bsuir.ief.rest.dao.hibernatedao.PersonHibernate;
import by.bsuir.ief.rest.model.entity.Person;
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
 * Created by andrey on 26.04.2016.
 */
@Component
public class PersonService {


    @Qualifier("personHibernate")
    @Autowired
    private PersonDAO personDao;

    /**
     *
     * @param person
     * @return
     * @throws BadAddEntityException
     */
    public Person add(Person person) throws BadAddEntityException {
        try {
            person = personDao.create(person);
        } catch (Exception e) {
            throw new BadAddEntityException(Person.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Person read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Person person = null;
        try {
            person = personDao.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Person.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Person> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Person> list = null;
        try {
            list = personDao.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Person.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param person
     * @return
     * @throws BadUpdateException
     */
    public Person update(Person person) throws BadUpdateException {
        try {
            person = personDao.update(person);
        } catch (Exception e) {
            throw  new BadUpdateException(Person.class.toString(),e);
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
            personDao.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Person.class.toString(),e);
        }
    }
}
