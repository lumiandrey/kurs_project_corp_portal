package by.bsuir.ief.rest.service;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.dao.pisl.PersonPislDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by andrey on 12.04.2016.
 */
@Component
public class PersonPislService {

    @Qualifier("personPislDAOImpl1")
    @Autowired
    private PersonPislDAO personPislDAOImpl1;
}
