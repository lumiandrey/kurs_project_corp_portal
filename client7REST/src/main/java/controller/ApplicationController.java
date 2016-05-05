package controller;


import model.ConnectionServer;
import model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ApplicationController {


    @Qualifier("connectionServer")
    @Autowired
    private ConnectionServer server;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main() throws Exception {
        System.out.println("hello");
        return new ModelAndView("table", "listPerson", server.getAllPerson());
    }

    @RequestMapping(value = "/check-add", method = RequestMethod.POST)
    public String checkPersonAdd(@Valid @ModelAttribute("addPerson") PersonPisl person, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        server.saveOrUpdate(person);
        return "redirect:/";
    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {
        return new ModelAndView("add", "addPerson", new PersonPisl());
    }

    @RequestMapping(value = "/check-edit", method = RequestMethod.POST)
    public String checkPersonEdit(@Valid @ModelAttribute("editPerson") PersonPisl person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        server.putPerson(person);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPerson(@PathVariable("id")int id)
    {
        try {
            PersonPisl personPisl = server.getPersonById(id);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("editPerson",personPisl);
            modelAndView.setViewName("edit");
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id")int id)
    {
        try {
             server.deletePersonById(id);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
