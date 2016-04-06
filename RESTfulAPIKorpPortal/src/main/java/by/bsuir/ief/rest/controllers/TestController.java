package by.bsuir.ief.rest.controllers;

import by.bsuir.ief.rest.dao.hibernatedao.UserHibernate;
import by.bsuir.ief.rest.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andrey on 05.04.2016.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public void connectionTestHibernate()
    {
        System.out.println(sessionFactory);
        UserHibernate userHibernate = new UserHibernate();
        User user = new User();
        user.setLogin("root");
        user.setPassword("root");
    }

}
