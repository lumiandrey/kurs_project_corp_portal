package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.model.service.ShowUnreadedMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by andrey on 06.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class ShowUnreadedMessageTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private ShowUnreadedMessageService service;

    @Test
    public void readUsers()  {
        List<ShowUnreadedMessage> messages = null;
        try {
            messages = service.read(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(messages);
    }
}
