package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.util.Status;
import by.bsuir.ief.rest.model.pisl.*;
import by.bsuir.ief.rest.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    ///////////////////GET METHOD/////////////////////
    /**
     *
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<PersonPisl> getAllPerson()
    {
        List<PersonPisl> personPisls = null;
        try {
            personPisls = personPislDAOImpl1.getEntityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public PersonPisl getPersonByID(@PathVariable("id") int id)
    {
        PersonPisl personPisl = null;
        try {
            personPisl = personPislDAOImpl1.getEntityById(id);
        } catch (UserNotFoundException e){
            throw e;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return personPisl;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/defaultperson/{name}", method = RequestMethod.GET)
    public PersonPisl getDefaultPersonAndrey(@PathVariable("name")String name)
    {
        PersonPisl personPisl = new PersonPisl();
        return personPisl;
    }

    ///////////////////PUT METHOD/////////////////////
    /**
     *
     * @param personPisl
     * @return
     */
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public PersonPisl putPerson(@RequestBody PersonPisl personPisl)
    {
        try {
            personPisl = personPislDAOImpl1.addEntity(personPisl);
            return personPisl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.PUT)
    public List<PersonPisl> putListPersonPisl(@RequestBody List<PersonPisl> personPisls)
    {
        List<PersonPisl> pisls= null;
        try {
            pisls = personPislDAOImpl1.addEntitys(personPisls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pisls;
    }

    ///////////////////POST METHOD/////////////////////

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public PersonPisl addPerson(@RequestBody PersonPisl personPisl)
    {
        try {
            personPisl = personPislDAOImpl1.addEntity(personPisl);
        } catch (Exception e) {
            e.printStackTrace();
            personPisl = null;
        }
        return personPisl;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public List<PersonPisl> addPersons(@RequestBody List<PersonPisl> personPisls)
    {
        try {
            personPisls = personPislDAOImpl1.addEntitys(personPisls);
        } catch (Exception e) {
            e.printStackTrace();
            personPisls = null;
        }
        return personPisls;
    }
    ///////////////////DELETE METHOD/////////////////////

    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    public Status deletePersonById(@PathVariable("id")int id)
    {
        try {
            personPislDAOImpl1.deleteEntity(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(400, e.toString());
        }
        return new Status(200,"Good delete to Server!");
    }

    @RequestMapping (value = "/persons", method = RequestMethod.DELETE)
    public Status deletePersons()
    {
        try {
            personPislDAOImpl1.deleteAllEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(400,e.toString());
        }
        return new Status(200,"Good all delete Persons");
    }


}
