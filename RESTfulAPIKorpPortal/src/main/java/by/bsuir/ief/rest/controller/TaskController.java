package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Task;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.TaskService;
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
@RequestMapping("/taskapi")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@PathVariable("id") int id)
    {
        Task task = null;
        try {
            task = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return task;
    }

    @RequestMapping(value = "/taskes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTask()
    {
        List<Task> list = null;
        try {
            list = service.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/task-by-person/{id}", method = RequestMethod.GET)
    public List getTaskByIdPerson(@PathVariable("id") int id){
        List list = null;
        try {
            list = service.getTaskByIdPerson(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return list;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Task createTask(@RequestBody Task task)
    {
        try {
            task = service.add(task);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return task;
    }

    @RequestMapping(value = "/add-task-by-person/{idPerson}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Task createTaskByPerson(@RequestBody Task task, @PathVariable("idPerson") int idPerson)
    {
        try {
            task = service.addTaskByPerson(task,idPerson);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return task;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public Task putTask(@RequestBody Task task)
    {
        try {
            task = service.update(task);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return task;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/task/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskById(@PathVariable("id")int id)
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
