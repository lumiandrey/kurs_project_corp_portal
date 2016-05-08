package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.MessageDAO;
import by.bsuir.ief.rest.dao.ShowUnreadedMessageDAO;
import by.bsuir.ief.rest.model.entity.Message;
import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
public class MessageService {
    @Qualifier("messageHibernate")
    @Autowired
    private MessageDAO messageHibernate;

    @Qualifier("showUnreadedMessageDAOMySQL")
    @Autowired
    private ShowUnreadedMessageDAO messageDAO;

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Message read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Message person = null;
        try {
            person = messageHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Message.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Message> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Message> list = null;
        try {
            list = messageHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Message.class.toString(),e);
        }
        return list;
    }


    /**
     *
     * @param message
     * @return
     * @throws EntityNotFoundByParametrsException
     * @throws BadGetEntityException
     */

    public Message add(Message message) throws BadAddEntityException {
        try {
             message = messageHibernate.create(message);
        } catch (Exception e) {
            throw new BadAddEntityException(Message.class.toString(),e);
        }
        return message;
    }

    public Message sendMessageToReciverId(Message message, int idReciver) throws BadAddEntityException {
        try{
            message = messageHibernate.create(message);
            messageDAO.insertMessageReciverTable(message.getIdMessage(),idReciver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadAddEntityException(Message.class.toString(),e);
        }
        return message;
    }


    /**
     *
     * @param message
     * @return
     * @throws BadUpdateException
     */
    public Message update(Message message) throws BadUpdateException {
        try {
            message = messageHibernate.update(message);
        } catch (Exception e) {
            throw  new BadUpdateException(Message.class.toString(),e);
        }
        return message;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            messageHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Message.class.toString(),e);
        }
    }

    public List<ShowUnreadedMessage> readUnreaded(int idUser) throws Exception {
        return messageDAO.readByUserId(idUser);
    }

    public List<ShowUnreadedMessage> readMessagesByIdSender( int idReciver, int idSenser) throws Exception {
        return messageDAO.readMessagesByIdSender(idReciver, idSenser);
    }
}
