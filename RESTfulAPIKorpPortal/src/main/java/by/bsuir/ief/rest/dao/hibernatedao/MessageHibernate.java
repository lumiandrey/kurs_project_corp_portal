package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.MessageDAO;

import by.bsuir.ief.rest.model.entity.Message;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
@Repository
@Transactional
public class MessageHibernate implements MessageDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_MESSAGE = "from Message where idMessage = :idMessage";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Message create(Message message) throws Exception {
        getCurrentSession().save(message);
        return message;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Message> read() throws Exception {
        List<Message> messages = getCurrentSession().createCriteria(Message.class).list();
        if(messages == null)
            throw new AllEntityNotFountException(Message.class.toString());
        return messages;
    }

    @Override
    @Transactional(readOnly=true)
    public Message read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_MESSAGE);
        query.setParameter("idMessage", id);
        Message message = (Message) query.uniqueResult();
        if(message == null )
            throw new EntityNotFoundByIdException(id,Message.class.getName());
        return message;
    }

    @Override
    public Message update(Message message) throws Exception {
        getCurrentSession().update(message);
        return message;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_MESSAGE);
        query.setParameter("idMessage", id);
        Message message = (Message) query.uniqueResult();
        if(message == null )
            throw new EntityNotFoundByIdException(id,Message.class.getName());
        session.delete(message);
    }
}
