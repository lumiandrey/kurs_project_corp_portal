package controller;


import model.ConnectionServer;
import model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ApplicationController {


    @Qualifier("connectionServer")
    @Autowired
    private ConnectionServer server;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main() throws Exception {
        return new ModelAndView("table", "listPerson", server.getAllPerson());
    }

    @RequestMapping(value = "/check-add", method = RequestMethod.POST)
    public String checkPersonAdd(@Valid @ModelAttribute("person") PersonPisl person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
//если всё в порядке, добавляем в список на странице table
        return "table";
    }

    @RequestMapping(value = "/check-edit", method = RequestMethod.POST)
    public String checkPersonEdit(@Valid @ModelAttribute("person") PersonPisl person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
//если всё в порядке, обновляем список на странице table
        return "table";
    }










}
