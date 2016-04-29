package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.PersonEntity;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.PersonService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 20.04.2016.
 */
@RestController
@RequestMapping("/personapi")
public class PersonController {


    @Qualifier("personService")
    @Autowired
    private PersonService personService;

    //----------------------BEGIN GET METHOD-------------------------//

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PersonEntity getPerson(@PathVariable("id") int id)
    {
        PersonEntity person = null;
        try {
            person = personService.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return person;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PersonEntity> getPerson()
    {
        List<PersonEntity> list = null;
        try {
            list = personService.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    //---------------------END GET METHOD----------------------------//
    //*********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public PersonEntity create(@RequestBody PersonEntity person)
    {
        try {
            person = personService.add(person);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return person;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public PersonEntity putPerson(@RequestBody PersonEntity personPisl)
    {
        try {
            personPisl = personService.update(personPisl);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return personPisl;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonById(@PathVariable("id")int id)
    {
        try {
            personService.delete(id);
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    //---------------------END DELETE METHOD-------------------------//
}
