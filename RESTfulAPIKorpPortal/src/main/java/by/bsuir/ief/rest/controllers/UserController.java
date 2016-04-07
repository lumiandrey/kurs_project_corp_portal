package by.bsuir.ief.rest.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Даша on 06.04.2016.
 */
@Controller
@RequestMapping("/usersapi")
public class UserController {

    static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/create")
    public void create()
    {
        System.out.println("Create User!!!");
    }

    @RequestMapping(value = "/delete")
    public void delete()
    {
        System.out.println("complete user delete ");
        System.out.println("Hello Dasha!!");
        System.out.println("Hello world");
        System.out.println("you");
    }
}
