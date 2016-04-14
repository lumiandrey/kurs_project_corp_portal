package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Comment;

import java.util.List;

/**
 * Created by andrey on 14.04.2016.
 */
public interface CommentDAO {
    void create(Comment createUser) throws Exception;
    List<Comment> readAll() throws Exception;
    Comment read(int id) throws Exception;
    void delete(int id) throws Exception;
    void update(Comment person);
}
