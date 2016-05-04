package by.bsuir.ief.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;

/**
 * Created by andrey on 03.05.2016.
 */
@RestController
@RequestMapping("/option")
public class OptionRestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Integer getStatusServer()
    {
        return 200;
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public GregorianCalendar getTimeServer()
    {
        return new GregorianCalendar();
    }


}
