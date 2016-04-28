package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.LikeDAO;
import by.bsuir.ief.rest.model.entity.Like;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
@Transactional
public class LikeHibernate implements LikeDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_LIKE = "from Like where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Like create(Like like) throws Exception {
        getCurrentSession().save(like);
        return like;
    }

    @Override
    public List<Like>  create(List<Like> like) throws Exception {
        Session session = getCurrentSession();
        for(Like s: like)
            session.save(s);
        return like;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Like> read() throws Exception {
        List<Like> likes = getCurrentSession().createCriteria(Like.class).list();
        if(likes == null)
            throw new AllEntityNotFountException(Like.class.toString());
        return likes;
    }

    @Override
    @Transactional(readOnly=true)
    public Like read(int id) throws Exception {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_LIKE);
        query.setParameter("id", id);
        Like like = (Like) query.uniqueResult();
        if(like == null )
            throw new EntityNotFoundByIdException(id,Like.class.getName());
        return like;
    }

    @Override
    public void delete(int id) throws Exception {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_LIKE);
        query.setParameter("id", id);
        Like like = (Like) query.uniqueResult();
        if(like == null) {
            throw new EntityNotFoundByIdException(id, Like.class.getName());
        }
        session.delete(like);
    }
}
