package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Message;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.entity.views.ShowUnreadedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Darya on 29.04.16.
 */
@Controller
@RequestMapping("/messages")
public class MessageController {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String openMessage(HttpSession session, Model model)
    {
        for(String o :session.getValueNames())
            System.out.println(o);
        return "";
    }


    private List<ShowUnreadedMessage> init()
    {
        List<ShowUnreadedMessage> list = new ArrayList();
        ShowUnreadedMessage message = new ShowUnreadedMessage();
        message.setContent("content text");
        message.setDate(new Date());
        message.setLogin("root");
        message.setUserRec(1);
        message.setUserSender(2);
        list.add(message);
        message = new ShowUnreadedMessage();
        message.setContent("content text");
        message.setDate(new Date());
        message.setLogin("login");
        message.setUserRec(1);
        message.setUserSender(3);
        list.add(message);
        return list;
    }


    @RequestMapping(value = "/listMessages", method = RequestMethod.GET)
    public ModelAndView listMessages(){
        //-------Логика получениянепрочитанных сообщений с сервера-----------------//

        return new ModelAndView(ClientURL.getProperty("url.listMessages"), "listMessage", init());
    }

    @RequestMapping(value = "/messagesWithOne/{idSender}", method = RequestMethod.GET)
    public ModelAndView messagesWithOne(@PathVariable("idSender") int idSender){
        System.out.println(idSender);
        return new ModelAndView(ClientURL.getProperty("url.messagesWithOne"), "message", new Message());
    }



    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

            modelAndView.setViewName(ClientURL.getProperty("url.listMessages"));
            User user = (User) session.getAttribute("user");
            modelAndView.addObject("user", user);
            /*Список непрочитанных сообщений*/

        return modelAndView;
    }

}
