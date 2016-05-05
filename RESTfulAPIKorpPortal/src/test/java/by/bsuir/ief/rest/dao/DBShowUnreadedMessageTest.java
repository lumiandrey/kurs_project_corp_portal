package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.service.ShowUnreadedMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrey on 05.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class DBShowUnreadedMessageTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private ShowUnreadedMessageService service;

    @Test
    public void readAllTest() throws BadGetEntityException, AllEntityNotFountException {
        List<ShowUnreadedMessage> list = null;
        try {
            list = service.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }
}
