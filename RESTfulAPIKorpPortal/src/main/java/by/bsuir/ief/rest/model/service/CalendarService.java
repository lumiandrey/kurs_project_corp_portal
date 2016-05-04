package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.CalendarDAO;
import by.bsuir.ief.rest.dao.hibernatedao.CalendarHibernate;
import by.bsuir.ief.rest.model.entity.Calendar;
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
public class CalendarService {


    @Qualifier("calendarHibernate")
    @Autowired
    private CalendarDAO calendarHibernate;

    public CalendarService(CalendarHibernate calendarHibernate) {
        this.calendarHibernate = calendarHibernate;
    }

    public CalendarService() {
    }

    /**
     *
     * @param calendar
     * @return
     * @throws BadAddEntityException
     */
    public Calendar add(Calendar calendar) throws BadAddEntityException {
        try {
            calendar = calendarHibernate.create(calendar);
        } catch (Exception e) {
            throw new BadAddEntityException(Calendar.class.toString(),e);
        }
        return calendar;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Calendar read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Calendar comment = null;
        try {
            comment = calendarHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Calendar.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Calendar> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Calendar> list = null;
        try {
            list = calendarHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Calendar.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param comment
     * @return
     * @throws BadUpdateException
     */
    public Calendar update(Calendar comment) throws BadUpdateException {
        try {
            comment = calendarHibernate.update(comment);
        } catch (Exception e) {
            throw  new BadUpdateException(Calendar.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public boolean delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        boolean delete = false;
        try {
            delete = calendarHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(), Calendar.class.toString(),e);
        }
        return delete;
    }
}
