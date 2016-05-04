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
        session.invalidate();
        return new ModelAndView(ClientURL.getProperty("url.login")/*"index"*/, "user", new User());
    }
}
