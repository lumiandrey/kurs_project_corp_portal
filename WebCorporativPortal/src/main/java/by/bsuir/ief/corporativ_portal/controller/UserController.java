package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user-control")
public class UserController {

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public String logIn(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            try {
                user = userService.autorized(user);
                model.addAttribute("user", user);
                model.addAttribute("person", user.getPerson());
                model.addAttribute("department", user.getPerson().getDepatment());
                model.addAttribute("post", user.getPerson().getPost());
                model.addAttribute("city", user.getPerson().getCity());
                model.addAttribute("country", user.getPerson().getCity().getCountry());
                session.setAttribute("user", user);
                return ClientURL.getProperty("url.main");
            } catch (Exception e) {
                e.printStackTrace();
                return ClientURL.getProperty("url.error.wrongloginorpassword");
            }
        } else {
            return ClientURL.getProperty("url.login");
        }
    }

    @RequestMapping(value = "log-out", method = RequestMethod.GET)
    public String logOut(HttpSession session, ModelMap model)
    {
        model.clear();
        session.invalidate();
        return "redirect:/";
    }


}
