package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Post;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface PostDAO {
    /**
     *
     * @param post
     * @throws Exception
     */
    Post create(Post post) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Post> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Post read(int id) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     *
     * @param post
     */
    void update(Post post);
}
