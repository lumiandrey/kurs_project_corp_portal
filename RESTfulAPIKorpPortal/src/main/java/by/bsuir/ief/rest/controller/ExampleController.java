package by.bsuir.ief.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrey on 27.04.2016.
 */
@RestController
@RequestMapping("/example")
public class ExampleController {

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String get()
    {
        return "Hello World GET";
    }

    //---------------------END GET METHOD----------------------------//


    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String post()
    {
        return "Hello World POST";
    }

    //---------------------END POST METHOD---------------------------//


    //---------------------BEGIN PUT METHODS-------------------------//

    /**
     * method = RequestMethod.PUT
     */

    //---------------------END PUT METHOD----------------------------//


    //--------------------BEGIN DELETE METHODS-----------------------//
    /**
     * method = RequestMethod.DELETE
     */
    //---------------------END DELETE METHOD-------------------------//
}
