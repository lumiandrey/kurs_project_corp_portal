package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.TypeTask;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.TypeTaskService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 30.04.2016.
 */
@RestController
@RequestMapping("/typetaskkapi")
public class TypeTaskController {

    private TypeTaskService service;

    @Autowired
    public TypeTaskController(TypeTaskService service) {
        this.service = service;
    }

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/typetask/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TypeTask getTypeTaskById(@PathVariable("id") int id)
    {
        TypeTask typeTask = null;
        try {
            typeTask = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return typeTask;
    }

    @RequestMapping(value = "/typetaskes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TypeTask> getAllTypeTask()
    {
        List<TypeTask> list = null;
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

    @RequestMapping(value = "/typetask", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public TypeTask createTypeTask(@RequestBody TypeTask typeTask)
    {
        try {
            typeTask = service.add(typeTask);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return typeTask;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/typetask", method = RequestMethod.PUT)
    public TypeTask putTypeTask(@RequestBody TypeTask typeTask)
    {
        try {
            typeTask = service.update(typeTask);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return typeTask;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/typetask/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTypeTaskById(@PathVariable("id")int id)
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
