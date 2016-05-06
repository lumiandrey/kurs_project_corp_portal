package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Darya on 29.04.16.
 */
@Controller
public class RedirectController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session.isNew()) {
            modelAndView.setViewName(ClientURL.getProperty("url.login"));
            modelAndView.addObject("user", new User());
        }
        else {
            modelAndView.setViewName(ClientURL.getProperty("url.main"));
            User user = (User) session.getAttribute("user");
            modelAndView.addObject("user", user);
            modelAndView.addObject("person", user.getPerson());
            modelAndView.addObject("department", user.getPerson().getDepatment());
            modelAndView.addObject("post", user.getPerson().getPost());
            modelAndView.addObject("city", user.getPerson().getCity());
            modelAndView.addObject("country", user.getPerson().getCity().getCountry());
        }
        return modelAndView;
    }
}
