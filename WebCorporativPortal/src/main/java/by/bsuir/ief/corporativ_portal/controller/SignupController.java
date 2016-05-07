package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.entity.TypeUser;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.service.PersonService;
import by.bsuir.ief.corporativ_portal.model.service.TypeUserService;
import by.bsuir.ief.corporativ_portal.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/signup-control")
public class SignupController {


    @Qualifier("personService")
    @Autowired
    private PersonService personService;
    @Qualifier("userService")
    @Autowired
    private UserService userService;
    @Qualifier("typeUserService")
    @Autowired
    private TypeUserService typeUserService;


    @RequestMapping(value = "/signup_2steps", method = RequestMethod.GET)
    public ModelAndView singUpPersonSteps(){
        return new ModelAndView(ClientURL.getProperty("url.signup_2steps"));
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView singUpPersonStepOne(){
        return new ModelAndView(ClientURL.getProperty("url.signup"), "person", new Person());
    }



    @RequestMapping(value = "/check-fio", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model,HttpSession session ) {
        if (bindingResult.hasErrors()) {
            return ClientURL.getProperty("url.signup");
        }
        try {
            //------проверка по базе личности-------//
            person = personService.getByFIO(person);
            User user = userService.getUserByIdPerson(person.getIdPerson());
            if(user == null)
                session.setAttribute("person",person);
            else
                throw new Exception();
            //----------------делаем--------//
            model.addAttribute("user", new User());
            return "redirect:/signup-control/signup2";
        } catch (Exception e){
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session){
        if(!bindingResult.hasErrors())
        {
            TypeUser typeUser = typeUserService.getTypeUserById(2);
            Person person = (Person) session.getAttribute("person");
            user.setType_user(typeUser);
            user.setPerson(person);
            if(userService.registrationUser(user))
            {
                session.invalidate();
                return "redirect:/";
            }
            else return "redirect:/error";
            //-----Logic Add User to Base-----//
        }
        else
            return ClientURL.getProperty("url.signup2");
    }


    @RequestMapping(value = "/signup2", method = RequestMethod.GET)
    public ModelAndView singUpPersonStepTwo(){
        return new ModelAndView(ClientURL.getProperty("url.signup2"), "user", new User());
    }

    @RequestMapping(value = "/checkStrength", method = RequestMethod.POST, produces = { "text/html; charset=UTF-8" })
    public @ResponseBody
    String checkStrength(@RequestParam String password) {
        System.out.println("hello controller!!!");
        String result = "<span style=\"color:%s; font-weight:bold;\">%s</span>";

        if (password.length() >= 3 & password.length() < 5) {
            // добавить локализацию
            return String.format(result, "red", "Слабый");
        } else if (password.length() >= 5 & password.length() < 7) {
            return String.format(result, "yellow", "Средний");
        } else if (password.length() >= 7) {
            return String.format(result, "green", "Сильный");
        }
        return "";
    }
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = { "text/html; charset=UTF-8" })
    public @ResponseBody
    String checkLogin(@RequestParam String login) {
        System.out.println("checkLogin!!!");
        String result = "<span style=\"color:%s; font-weight:bold;\">%s</span>";
        User user = userService.getUserByLogin(login);
        return (user != null?
                String.format(result, "red", "Логин занят!!!")  :
                String.format(result, "green", "Логин свободен!:)"));
    }


}
