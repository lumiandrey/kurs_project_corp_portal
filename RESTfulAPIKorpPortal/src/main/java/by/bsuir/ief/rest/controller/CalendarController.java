package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Calendar;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.CalendarService;
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
@RequestMapping("/calendarapi")
public class CalendarController {

    private CalendarService service;

    @Autowired
    public CalendarController(CalendarService service) {
        this.service = service;
    }


//----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/calendar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Calendar getCalendarById(@PathVariable("id") int id)
    {
        Calendar calendar = null;
        try {
            calendar = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return calendar;
    }

    @RequestMapping(value = "/calendars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Calendar> getAllCalendar()
    {
        List<Calendar> list = null;
        try {
            list = service.read();
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

    @RequestMapping(value = "/calendar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Calendar createCalendar(@RequestBody Calendar calendar)
    {
        try {
            calendar = service.add(calendar);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return calendar;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/calendar", method = RequestMethod.PUT)
    public Calendar putCalendar(@RequestBody Calendar calendar)
    {
        try {
            calendar = service.update(calendar);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return calendar;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/calendar/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCalendarById(@PathVariable("id")int id)
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
