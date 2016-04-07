package by.bsuir.ief.rest.service;

import by.bsuir.ief.rest.dao.hibernatedao.UserHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Андрей on 07.04.2016.
 */
@Component
public class UsersService {

    @Autowired
    private UserHibernate userHibernate;

}
