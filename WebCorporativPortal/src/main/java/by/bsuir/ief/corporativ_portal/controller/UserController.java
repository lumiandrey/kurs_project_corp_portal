package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.service.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user-control")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Qualifier("serviceManager")
    @Autowired
    private ServiceManager serviceManager;

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            try {
                user = serviceManager.getUserByLogin(user);
                model.addAttribute("user", user);
                model.addAttribute("person", user.getPerson());
                session.setAttribute("user", user);
                return ClientURL.getProperty("url.main");
            } catch (Exception e) {
                e.printStackTrace();
                logger.warn(e.getMessage());
                return ClientURL.getProperty("url.error.wrongloginorpassword");
            }
        } else {
            return ClientURL.getProperty("url.login");
        }
    }


}
