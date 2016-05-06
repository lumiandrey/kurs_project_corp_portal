package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SingupController {


    @RequestMapping(value = "/singup", method = RequestMethod.GET)
    public ModelAndView singUpPersonStepOne(){
        return new ModelAndView(ClientURL.getProperty("url.singup"), "person", new Person());
    }

    @RequestMapping(value = "/check-fio", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return ClientURL.getProperty("url.singup");
        }
        try {
            model.addAttribute("user", new User());
            return ClientURL.getProperty("url.singup2");
        }catch (Exception e){
            return ClientURL.getProperty("url.error.wrongfio");
        }
    }

    @RequestMapping(value = "/singup2", method = RequestMethod.POST)
    public ModelAndView singUpPersonStepTwo(Model model){
        return new ModelAndView(ClientURL.getProperty("url.singup2"), "user", new User());
    }

    @RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = { "text/html; charset=UTF-8" })
    public @ResponseBody
    String checkStrength(@RequestParam String name) {
        String result = "<span style=\"color:%s; font-weight:bold;\">%s</span>";

        if (name.length() >= 3 & name.length() < 5) {
            // добавить локализацию
            return String.format(result, "red", "Слабый");
        } else if (name.length() >= 5 & name.length() < 7) {
            return String.format(result, "yellow", "Средний");
        } else if (name.length() >= 7) {
            return String.format(result, "green", "Сильный");
        }
        return "";
    }
}
