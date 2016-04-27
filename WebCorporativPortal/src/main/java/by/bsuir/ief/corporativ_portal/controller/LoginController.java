package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("index", "user", new User());
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "old/login";
        }
        model.addAttribute("user", user);
        return "old/main";
    }

    @RequestMapping(value = "/sing-up", method = RequestMethod.POST)
    public ModelAndView singUpPersonStepOne(){
        return new ModelAndView("old/singup", "user", new User());
    }

    @RequestMapping(value = "/sing-up-2", method = RequestMethod.POST)
    public ModelAndView singUpPersonStepTwo(){
        return new ModelAndView("old/singup2", "person", new Person());
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
