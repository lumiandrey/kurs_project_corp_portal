package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Department;

import java.util.List;

/**
 * Created by andrey on 24.04.2016.
 */
public interface DepartmentDAO {
    /**
     *
     * @param createDepartment
     * @return
     * @throws Exception
     */
    Department create(Department createDepartment) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List read() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Department read(int id) throws Exception;

    /**
     *
     * @param updateDepartment
     * @return
     */
    Department update(Department updateDepartment)throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    boolean delete(int id) throws Exception;


}
