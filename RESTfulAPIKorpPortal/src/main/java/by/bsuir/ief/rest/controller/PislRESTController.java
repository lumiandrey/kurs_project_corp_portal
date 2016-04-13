package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.dao.pisl.PersonPislDAOImpl;
import by.bsuir.ief.rest.model.pisl.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@RestController
@RequestMapping("/pislrest")
public class PislRESTController {


    @Qualifier("personPislDAOImpl1")
    @Autowired
    private PersonPislDAO personPislDAOImpl1;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<PersonPisl> getAllPerson()
    {
        try {
            return personPislDAOImpl1.getEntityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
