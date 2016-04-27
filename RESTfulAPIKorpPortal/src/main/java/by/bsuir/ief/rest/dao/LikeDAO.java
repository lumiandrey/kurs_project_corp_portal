package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Like;

import java.util.List;

/**
 * Created by andrey on 24.04.2016.
 */
public interface LikeDAO {
    /**
     *
     * @param like
     * @throws Exception
     */
    Like create(Like like) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Like> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Like read(int id) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;
}
