package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.service.PersonPislService;
import by.bsuir.ief.rest.util.Status;
import by.bsuir.ief.rest.model.pisl.*;
import by.bsuir.ief.rest.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@RestController
@RequestMapping("/pislrest")
public class PislRESTController {

    @Autowired
    private PersonPislService pislService;

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
            personPisls = pislService.getAllPerson();
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
            personPisl = pislService.getPersonByID(id);
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
        return pislService.getDefaultPerson(name);
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
            personPisl = pislService.addPerson(personPisl);
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
    public List putListPersonPisl(@RequestBody List<PersonPisl> personPisls)
    {
        List pisls= null;
        try {
            pisls = pislService.addPersons(personPisls);
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
            personPisl = pislService.addPerson(personPisl);
        } catch (Exception e) {
            e.printStackTrace();
            personPisl = null;
        }
        return personPisl;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public List<PersonPisl> addPersons(@RequestBody List personPisls)
    {
        try {
            personPisls = pislService.addPersons(personPisls);
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
            pislService.deletePersonById(id);
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
            pislService.deleteAllPerson();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(400,e.toString());
        }
        return new Status(200,"Good all delete Persons");
    }


}
