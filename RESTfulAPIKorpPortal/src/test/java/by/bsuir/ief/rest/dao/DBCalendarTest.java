package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Calendar;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.CalendarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrey on 02.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class DBCalendarTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CalendarService service;

    private Calendar calendar = null;


    private static int find_id = 0;

    @Before
    public void init() throws BadGetEntityException, EntityNotFoundByIdException {
        calendar = new Calendar();
        calendar.setDate(new Date(1_235_456));
        calendar.setIdCalendar(0);
        calendar.setWeek(12);

        find_id = 1;

    }

    @Test
    public void createTest() throws BadAddEntityException {
        Calendar add = service.add(calendar);
        assertNotNull(add);
    }

    @Test
    public void readAllTest() throws BadGetEntityException, AllEntityNotFountException {
        List<Calendar> list = service.read();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void readById()
    {
        Calendar o = null;
        try {
            o = service.read(find_id);
        } catch (EntityNotFoundByIdException | BadGetEntityException e) {
            e.printStackTrace();
        }
        assertNotNull(o);
    }

    @Test
    public void updateEntity() throws BadGetEntityException, EntityNotFoundByIdException, CloneNotSupportedException, BadUpdateException {
        Calendar o = service.read(find_id);
        Calendar clone = (Calendar) o.clone();
        o.setQuartal(4);
        o = service.update(o);
        assertTrue(o.hashCode() != clone.hashCode());
    }

    @Test
    public void deleteEntityById() throws EntityNotFoundByIdException, BadDeleteEntityException {
        boolean delete = service.delete(1);
        assertTrue("good delete!",delete);
    }
}
