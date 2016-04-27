package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.CommentDAO;
import by.bsuir.ief.rest.model.entity.Comment;
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
public class CommentHibernate implements CommentDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;

    private final String HQL_FIND_BY_ID_COMMENT = "from Comment where idComment = :idComment";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Comment create(Comment comment) throws Exception {
        getCurrentSession().save(comment);
        return comment;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Comment> read() throws AllEntityNotFountException {
        List<Comment> comments = getCurrentSession().createCriteria(Comment.class).list();
        if(comments == null)
            throw new AllEntityNotFountException(Comment.class.toString());
        return comments;
    }

    @Override
    @Transactional(readOnly=true)
    public Comment read(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_COMMENT);
        query.setParameter("idComment", id);
        Comment comment = (Comment) query.uniqueResult();
        if(comment == null )
            throw new EntityNotFoundByIdException(id,Comment.class.getName());
        return comment;
    }

    @Override
    public Comment update(Comment comment) throws Exception {
        session = getCurrentSession();
        session.update(comment);
        return comment;
    }

    @Override
    public void delete(int id) throws EntityNotFoundByIdException {
        session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_COMMENT);
        query.setParameter("idComment", id);
        Comment comment = (Comment) query.uniqueResult();
        if(comment == null) {
            throw new EntityNotFoundByIdException(id, Comment.class.getName());
        }
        session.delete(comment);
    }
}
