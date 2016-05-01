package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.DepartmentDAO;
import by.bsuir.ief.rest.model.entity.Department;
import by.bsuir.ief.rest.model.entity.Task;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
public class DepartmentService {

    @Qualifier("departmentHibernate")
    @Autowired
    private DepartmentDAO departmentHibernate;

    /**
     *
     * @param department
     * @return
     * @throws BadAddEntityException
     */
    public Department add(Department department) throws BadAddEntityException {
        try {
            department = departmentHibernate.create(department);
        } catch (Exception e) {
            throw new BadAddEntityException(Task.class.toString(),e);
        }
        return department;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Department read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Department department = null;
        try {
            department = departmentHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Department.class.toString(),e);
        }
        return department;
    }

    /**
     *
     * @return List<Department>
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Department> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Department> list = null;
        try {
            list = departmentHibernate.read();
        } catch (Exception e) {
            throw new BadGetEntityException(Department.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param department
     * @return
     * @throws BadUpdateException
     */
    public Department update(Department department) throws BadUpdateException {
        try {
            department = departmentHibernate.update(department);
        } catch (Exception e) {
            throw  new BadUpdateException(Department.class.toString(),e);
        }
        return department;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            departmentHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Department.class.toString(),e);
        }
    }
}
