package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.CommentDAO;
import by.bsuir.ief.rest.dao.hibernatedao.CommentHibernate;
import by.bsuir.ief.rest.dao.hibernatedao.CountryHibernate;
import by.bsuir.ief.rest.model.entity.Comment;
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
public class CommentService {

    @Qualifier("commentHibernate")
    @Autowired
    private CommentDAO commentHibernate;

    /**
     *
     * @param comment
     * @return
     * @throws BadAddEntityException
     */
    public Comment add(Comment comment) throws BadAddEntityException {
        try {
            comment = commentHibernate.create(comment);
        } catch (Exception e) {
            throw new BadAddEntityException(Comment.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Comment read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Comment comment = null;
        try {
            comment = commentHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Comment.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Comment> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Comment> list = null;
        try {
            list = commentHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Comment.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param comment
     * @return
     * @throws BadUpdateException
     */
    public Comment update(Comment comment) throws BadUpdateException {
        try {
            comment = commentHibernate.update(comment);
        } catch (Exception e) {
            throw  new BadUpdateException(Comment.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            commentHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Comment.class.toString(),e);
        }
    }
}
