package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.PostDAO;
import by.bsuir.ief.rest.model.entity.Post;
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
public class PostService {

    @Qualifier("postHibernate")
    @Autowired
    private PostDAO postHibernate;

    /**
     *
     * @param post
     * @return
     * @throws BadAddEntityException
     */
    public Post add(Post post) throws BadAddEntityException {
        try {
            post = postHibernate.create(post);
        } catch (Exception e) {
            throw new BadAddEntityException(Post.class.toString(),e);
        }
        return post;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Post read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Post post = null;
        try {
            post = postHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Post.class.toString(),e);
        }
        return post;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Post> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Post> list = null;
        try {
            list = postHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Post.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param post
     * @return
     * @throws BadUpdateException
     */
    public Post update(Post post) throws BadUpdateException {
        try {
            post = postHibernate.update(post);
        } catch (Exception e) {
            throw  new BadUpdateException(Post.class.toString(),e);
        }
        return post;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            postHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Post.class.toString(),e);
        }
    }
}
