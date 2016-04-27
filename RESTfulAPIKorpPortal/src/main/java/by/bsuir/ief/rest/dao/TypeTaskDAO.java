package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.TypeTask;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface TypeTaskDAO {
    /**
     *
     * @param typeTask
     * @throws Exception
     */
    TypeTask create(TypeTask typeTask) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<TypeTask> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    TypeTask read(int id) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     *
     * @param typeTask
     */
    void update(TypeTask typeTask);
}
