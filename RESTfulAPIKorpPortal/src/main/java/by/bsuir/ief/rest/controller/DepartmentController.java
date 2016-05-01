package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Department;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.DepartmentService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 20.04.2016.
 */
@RestController
@RequestMapping("/departmentapi")
public class DepartmentController {

    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartmentById(@PathVariable("id") int id)
    {
        Department department = null;
        try {
            department = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return department;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getAllDepartment()
    {
        List<Department> list = null;
        try {
            list = service.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Department create(@RequestBody Department department)
    {
        try {
            department = service.add(department);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return department;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    public Department putDepartment(@RequestBody Department depart)
    {
        try {
            depart = service.update(depart);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return depart;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/department/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteDepartmentById(@PathVariable("id")int id)
    {
        try {
            service.delete(id);
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    //---------------------END DELETE METHOD-------------------------//
}
