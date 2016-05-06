package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Person;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
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

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //----------------------BEGIN GET METHOD-------------------------//

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(@PathVariable("id") int id)
    {
        Person person = null;
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
    public List<Person> getPerson()
    {
        List<Person> list = null;
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
    public Person create(@RequestBody Person person)
    {
        try {
            person = personService.add(person);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return person;
    }

    @RequestMapping(value = "/personfio")
    public Person getPersonByFIO(@RequestBody Person person)
    {
        try {
            person = personService.readFIO(person);
        } catch (EntityNotFoundByParametrsException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return person;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public Person putPerson(@RequestBody Person personPisl)
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
