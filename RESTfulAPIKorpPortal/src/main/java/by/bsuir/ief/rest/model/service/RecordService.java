package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.RecordDAO;
import by.bsuir.ief.rest.dao.hibernatedao.RecordHibernate;
import by.bsuir.ief.rest.model.entity.Record;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Darya on 27.04.16.
 */
public class RecordService {

    @Qualifier("recordHibernate")
    @Autowired
    private RecordDAO recordHibernate;

    /**
     *
     * @param record
     * @return
     * @throws BadAddEntityException
     */
    public Record add(Record record) throws BadAddEntityException {
        try {
            record = recordHibernate.create(record);
        } catch (Exception e) {
            throw new BadAddEntityException(Record.class.toString(),e);
        }
        return record;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Record read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Record comment = null;
        try {
            comment = recordHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Record.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Record> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Record> list = null;
        try {
            list = recordHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Record.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param record
     * @return
     * @throws BadUpdateException
     */
    public Record update(Record record) throws BadUpdateException {
        try {
            record = recordHibernate.update(record);
        } catch (Exception e) {
            throw  new BadUpdateException(Record.class.toString(),e);
        }
        return record;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            recordHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(), Record.class.toString(),e);
        }
    }
}
