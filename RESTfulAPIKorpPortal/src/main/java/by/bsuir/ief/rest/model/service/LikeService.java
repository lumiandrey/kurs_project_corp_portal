package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.LikeDAO;
import by.bsuir.ief.rest.dao.hibernatedao.LikeHibernate;
import by.bsuir.ief.rest.model.entity.Like;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Darya on 28.04.16.
 */
@Component
public class LikeService {
    @Qualifier("likeHibernate")
    @Autowired
    private LikeDAO likeHibernate;

    /**
     *
     * @param task
     * @return
     * @throws BadAddEntityException
     */
    public Like add(Like task) throws BadAddEntityException {
        try {
            task = likeHibernate.create(task);
        } catch (Exception e) {
            throw new BadAddEntityException(Like.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @param likeList
     * @return
     * @throws BadAddEntityException
     */
    public List<Like> addlist(List<Like> likeList) throws BadAddEntityException {
        try {
            likeList = likeHibernate.create(likeList);
        } catch (Exception e) {
            throw new BadAddEntityException(Like.class.toString(),e);
        }
        return likeList;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Like read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Like task = null;
        try {
            task = likeHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Like.class.toString(),e);
        }
        return task;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Like> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Like> list = null;
        try {
            list = likeHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Like.class.toString(),e);
        }
        return list;
    }


    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            likeHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Like.class.toString(),e);
        }
    }

}
