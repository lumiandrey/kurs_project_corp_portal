package by.bsuir.ief.corporativ_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by andrey on 05.05.2016.
 */
@Controller
@RequestMapping("/person-control")
public class PersonController {

    @RequestMapping(value = "/show-person", method = RequestMethod.GET)
    public ModelAndView getPerson(HttpSession session)
    {
        return null;
    }
}
