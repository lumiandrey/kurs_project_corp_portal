package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void test()
    {
        System.out.println("Run test");
    }
}
