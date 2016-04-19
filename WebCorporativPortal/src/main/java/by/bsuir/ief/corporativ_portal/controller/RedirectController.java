package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andrey on 10.04.2016.
 */
@Controller
@RequestMapping("/")
public class RedirectController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView mainApplication()
    {
        return new ModelAndView("indexTMPExamle", "employee", new Employee());
    }

}
