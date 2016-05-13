package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.City;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.CityService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 30.04.2016.
 */
@RestController
@RequestMapping("/cityapi")
public class CityController {

    private CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City getCityById(@PathVariable("id") int id)
    {
        City city = null;
        try {
            city = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return city;
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCity()
    {
        List<City> list = null;
        try {
            list = service.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    @RequestMapping(value = "/cities-by-id-country/{idCountry}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByIdCountry(@PathVariable int idCountry)
    {
        List<City> list = null;
        try {
            list = service.readCityByIdCountry(idCountry);
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public City createCity(@RequestBody City city)
    {
        try {
            city = service.add(city);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return city;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public City putCity(@RequestBody City city)
    {
        try {
            city = service.update(city);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return city;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/city/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCityById(@PathVariable("id")int id)
    {
        try {
            service.delete(id);
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    //---------------------END DELETE METHOD-------------------------//
}
