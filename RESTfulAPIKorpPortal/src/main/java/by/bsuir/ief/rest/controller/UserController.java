package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import by.bsuir.ief.rest.model.service.UsersService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Андрей on 07.04.2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Qualifier("usersService")
    @Autowired
    private UsersService usersService;

    static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/autorized", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void autorization(@RequestBody User user)
    {
        try {
            usersService.autorizen(user);
        } catch (EntityNotFoundByParametrsException e) {
            logger.warn(e);
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void registration(@RequestBody User user)
    {
        try {
            usersService.registration(user);
        } catch (Exception e) {
            logger.warn(e);
            throw new BadExceptionRest(e.toString());
        }
    }

}
