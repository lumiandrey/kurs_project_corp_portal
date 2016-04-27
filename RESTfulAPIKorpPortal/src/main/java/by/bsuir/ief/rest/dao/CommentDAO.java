package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Comment;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CommentDAO {
    /**
     *
     * @param createUser
     * @throws Exception
     */
    Comment create(Comment createUser) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Comment> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Comment read(int id) throws Exception;

    /**
     *
     * @param person
     */
    void update(Comment person) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


}
