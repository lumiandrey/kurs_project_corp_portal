package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Task;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface TaskDAO {
    /**
     *
     * @param task
     * @throws Exception
     */
    Task create(Task task) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Task> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    List<Task> readTaskByIdPerson(int id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Task read(int id) throws Exception;

    /**
     *
     * @param task
     */
    Task update(Task task)throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


}
