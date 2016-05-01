package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import by.bsuir.ief.rest.model.service.UsersService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Андрей on 07.04.2016.
 */
@RestController
@RequestMapping("/userapi")
public class UserController {

    private UsersService service;

    @Autowired
    public UserController(UsersService service) {
        this.service = service;
    }

    static final Logger logger = Logger.getLogger(UserController.class);

    //----------------------BEGIN GET METHOD-------------------------//

    /**
     *
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> users = null;
        try {
            users = service.read();

        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
        return users;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id)
    {
        User user = null;
        try {
            user = service.read(id);
            WriteXML.write(user);
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
        return user;
    }

    /**
     *
     * @param login
     * @return
     */
    @RequestMapping(value = "/userlogin/{login}", method = RequestMethod.GET)
    public User getUserByLogin(@PathVariable("login") String login)
    {
        User user = null;
        try {
            user = service.getUserByLogin(login);
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByParametrsException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
        return user;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    /**
     *
     * @param user
     */
    @RequestMapping(value = "/autorized", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void autorization(@RequestBody User user)
    {
        try {
            service.autorizen(user);
        } catch (EntityNotFoundByParametrsException e) {
            logger.warn(e);
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
    }

    /**
     *
     * @param user
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void registration(@RequestBody User user)
    {
        try {
            service.registration(user);
        } catch (Exception e) {
            logger.warn(e);
            throw new BadExceptionRest(e.toString());
        }
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User putUser(@RequestBody User user)
    {
        try {
            user = service.update(user);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return user;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    /**
     *
     * @param id
     */
    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonById(@PathVariable("id")int id)
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
