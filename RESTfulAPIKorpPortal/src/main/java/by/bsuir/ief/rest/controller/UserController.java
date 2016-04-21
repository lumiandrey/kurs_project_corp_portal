package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.service.UsersService;
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void test()
    {
        System.out.println("Run test");
    }

    @RequestMapping(value = "/autorized", method = RequestMethod.POST)
    public void autorization(@RequestBody User user)
    {

    }
}
