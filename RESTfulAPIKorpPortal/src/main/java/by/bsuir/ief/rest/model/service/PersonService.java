package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.model.entity.PersonEntity;
import by.bsuir.ief.rest.dao.PersonDAO;
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
    public PersonEntity add(PersonEntity person) throws BadAddEntityException {
        try {
            person = personDao.create(person);
        } catch (Exception e) {
            throw new BadAddEntityException(PersonEntity.class.toString(),e);
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
    public PersonEntity read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        PersonEntity person = null;
        try {
            person = personDao.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            e.printStackTrace();
            throw new BadGetEntityException(PersonEntity.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<PersonEntity> read() throws AllEntityNotFountException, BadGetEntityException {
        List<PersonEntity> list = null;
        try {
            list = personDao.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(PersonEntity.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param person
     * @return
     * @throws BadUpdateException
     */
    public PersonEntity update(PersonEntity person) throws BadUpdateException {
        try {
            person = personDao.update(person);
        } catch (Exception e) {
            throw  new BadUpdateException(PersonEntity.class.toString(),e);
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
            throw new BadDeleteEntityException(e.getMessage(),PersonEntity.class.toString(),e);
        }
    }
}
