package by.bsuir.ief.rest.controllers;

import by.bsuir.ief.rest.dao.hibernatedao.UserHibernate;
import by.bsuir.ief.rest.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by andrey on 05.04.2016.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    static final Logger logger = Logger.getLogger(TestController.class);
    @RequestMapping(value = "/connect",  method = RequestMethod.GET)
    public void connectionTestHibernate()
    {
        UserHibernate userHibernate = new UserHibernate();
        User user = new User();
        user.setLogin("root");
        user.setPassword("root");
    }
    @RequestMapping("/")
    public void connect()
    {
        System.out.println("HelloWorld");
    }

}
