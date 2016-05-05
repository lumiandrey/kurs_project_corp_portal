package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.PostDAO;
import by.bsuir.ief.rest.model.entity.Post;
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
 * Created by andrey on 27.04.2016.
 */
@Repository
@Transactional
public class PostHibernate implements PostDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_POST = "from Post where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Post create(Post post) throws Exception {
        getCurrentSession().save(post);
        return post;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Post> read() throws AllEntityNotFountException {
        List<Post> likes = getCurrentSession().createCriteria(Post.class).list();
        if(likes == null)
            throw new AllEntityNotFountException(Post.class.toString());
        return likes;
    }

    @Override
    @Transactional(readOnly=true)
    public Post read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_POST);
        query.setParameter("id", id);
        Post post = (Post) query.uniqueResult();
        if(post == null )
            throw new EntityNotFoundByIdException(id,Post.class.getName());
        return post;
    }

    @Override
    public Post update(Post post) throws Exception {
        getCurrentSession().update(post);
        return post;
    }

    @Override
    public boolean delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_POST);
        query.setParameter("id", id);
        Post post = (Post) query.uniqueResult();
        if(post == null) {
            throw new EntityNotFoundByIdException(id, Post.class.getName());
        }
        session.delete(post);
        return true;
    }
}
