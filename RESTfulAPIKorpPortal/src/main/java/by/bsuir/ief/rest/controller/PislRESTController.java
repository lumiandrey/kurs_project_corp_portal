package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.PersonPislService;
import by.bsuir.ief.rest.model.pisl.*;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
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
        } catch (EntityNotFoundExceptionRest e){
            throw e;
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
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
            personPisl = pislService.updatePerson(personPisl);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
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
            pisls = pislService.updatePersons(personPisls);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return pisls;
    }

    ///////////////////POST METHOD/////////////////////

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public PersonPisl addPerson(@RequestBody PersonPisl personPisl)
    {
        try {
            personPisl = pislService.addPerson(personPisl);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return personPisl;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public List<PersonPisl> addPersons(@RequestBody List personPisls)
    {
        try {
            personPisls = pislService.addPersons(personPisls);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return personPisls;
    }

    @RequestMapping(value = "/personsaveorupdates", method = RequestMethod.POST)
    public List<PersonPisl> personSaveOrUpdates(@RequestBody List personPisls)
    {
        try {
            personPisls = pislService.saveOrUpdates(personPisls);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return personPisls;
    }

    @RequestMapping(value = "/personsaveorupdate", method = RequestMethod.POST)
    public PersonPisl personSaveOrUpdate(@RequestBody PersonPisl personPisl)
    {
        try {
            personPisl = pislService.saveOrUpdates(personPisl);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return personPisl;
    }
    ///////////////////DELETE METHOD/////////////////////

    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonById(@PathVariable("id")int id)
    {
        try {
            pislService.deletePersonById(id);
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    @RequestMapping (value = "/persons", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePersons()
    {
        try {
            pislService.deleteAllPerson();
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
    }

}
