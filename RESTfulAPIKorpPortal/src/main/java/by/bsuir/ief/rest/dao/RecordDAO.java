package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Record;

import java.util.List;

/**
 * Created by andrey on 26.04.2016.
 */
public interface RecordDAO{
    /**
     *
     * @param record
     * @throws Exception
     */
    Record create(Record record) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<Record> read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Record read(int id) throws Exception;

    /**
     *
     * @param record
     * @return
     * @throws Exception
     */
    Record update(Record record)throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


}
