package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @RequestMapping(value = "/edit-person", method = RequestMethod.POST)
    public String updatePerson(BindingResult bindingResult,View view, Model model, @Valid @ModelAttribute("person")Person person)
    {
        if(!bindingResult.hasErrors()) {
            return ClientURL.getProperty("url.login");
        }else
            return view.getContentType();

    }
}
