package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Calendar;

import java.util.List;

/**
 * Created by andrey on 08.04.2016.
 */
public interface CalendarDAO {
    void create(Calendar createUser) throws Exception;
    List<Calendar> readAll() throws Exception;
    Calendar read(int id) throws Exception;
    void delete(int id) throws Exception;
    void update(Calendar person);
}
