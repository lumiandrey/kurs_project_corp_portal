package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Department;

import java.util.List;

/**
 * Created by andrey on 24.04.2016.
 */
public interface DepartmentDAO {
    Department create(Department createDepartment) throws Exception;
    List read() throws Exception;
    Department read(int id) throws Exception;
    void delete(int id) throws Exception;
    Department update(Department updateDepartment);
}
