package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Message;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface MessageDAO {
    /**
     *
     * @param message
     * @throws Exception
     */
    Message create(Message message) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Message> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Message read(int id) throws Exception;

    /**
     *
     * @param message
     */
    Message update(Message message)throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


}
