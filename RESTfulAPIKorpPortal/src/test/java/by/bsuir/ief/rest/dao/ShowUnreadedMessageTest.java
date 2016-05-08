package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Message;
import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by andrey on 06.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class ShowUnreadedMessageTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private MessageService service;

    @Test
    public void readUsers()  {
        List<ShowUnreadedMessage> messages = null;
        try {
            messages = service.readUnreaded(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(messages);
    }

    @Test
    public void sendMessage()
    {
        Message message = new Message();
        message.setDate(new Date());
        message.setContent("Coool");
        message.setIdUserSender(3);
        Message id = null;
        try {
            id = service.sendMessageToReciverId(message,3);
        } catch (BadAddEntityException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        assertNotNull(message);
    }
}
