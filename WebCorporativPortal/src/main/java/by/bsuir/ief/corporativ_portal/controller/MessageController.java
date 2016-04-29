package by.bsuir.ief.corporativ_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Darya on 29.04.16.
 */
@Controller
@RequestMapping("messages")
public class MessageController {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String openMessage(HttpSession session, Model model)
    {
        for(String o :session.getValueNames())
            System.out.println(o);
        return "";
    }

}
