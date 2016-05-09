package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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


    @Qualifier("personService")
    @Autowired
    private PersonService service;

    @RequestMapping(value = "/show-person", method = RequestMethod.GET)
    public ModelAndView getPerson(HttpSession session)
    {
        return null;
    }

    @RequestMapping(value = "/edit-person", method = RequestMethod.POST)
    public String updatePerson(@Valid @ModelAttribute("person")Person person, BindingResult bindingResult,ModelMap model, HttpSession session ) throws Exception {
        if(!bindingResult.hasErrors()) {
            Person person1 = (Person) session.getAttribute("person");
            //--------initialization person model form-----------//
            person.setCity(person1.getCity());
            person.setDepartment(person1.getDepartment());
            person.setIdPerson(person1.getIdPerson());
            person.setPost(person1.getPost());
            //-----initialize person session atribute----------//
            person1.setLastName(person.getLastName());
            person1.setPatronymic(person.getPatronymic());
            person1.setName(person.getName());
            person1.seteMail(person.geteMail());
            person1.setSex(person.getSex());
            //person1.setStatus(person.getStatus());
            person1.setLinkSelfSite(person.getLinkSelfSite());
            //----------------update to service---------------//
            session.setAttribute("person", person1);
            service.update(person);
            model.replace("person", person);
            return ClientURL.getProperty("url.main");
        }else
            return ClientURL.getProperty("url.main");
    }

    @RequestMapping(value = "/showAllPerson",method = RequestMethod.GET)
    public ModelAndView showAllPerson()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("personList",service.getPersons());
        modelAndView.setViewName(ClientURL.getProperty("url.showAllPerson"));
        return modelAndView;
    }

    @RequestMapping(value = "/showAllPersonSort",method = RequestMethod.GET)
    public ModelAndView showAllPersonSort()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listPersonSort",service.getPersonsSorted());
        modelAndView.setViewName(ClientURL.getProperty("url.showAllPersonSort"));
        return modelAndView;
    }



    @RequestMapping(value = "/showDetails/{id}")
    public ModelAndView showDetails(@PathVariable("id")int idPerson, ModelMap modelMap)
    {
        return new ModelAndView(ClientURL.getProperty("url.showAllPerson"),modelMap);
    }

}
