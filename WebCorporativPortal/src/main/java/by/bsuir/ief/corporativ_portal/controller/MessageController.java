package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Message;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.corporativ_portal.model.service.MessageService;
import by.bsuir.ief.corporativ_portal.model.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
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


    @Qualifier("messageService")
    @Autowired
    private MessageService messageService;
    @Qualifier("userService")
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String openMessage(HttpSession session, Model model)
    {
        for(String o :session.getValueNames())
            System.out.println(o);
        return "";
    }

    @RequestMapping(value = "/listMessages", method = RequestMethod.GET)
    public ModelAndView listMessages(HttpSession session){
        //-------Логика получениянепрочитанных сообщений с сервера-----------------//
        List<ShowUnreadedMessage> list = messageService.getUnreadedMessage(((User)session.getAttribute("user")).getIdUser());
        return new ModelAndView(ClientURL.getProperty("url.listMessages"), "listMessage", list);
    }

    @RequestMapping(value = "/messagesWithOne/{idSender}", method = RequestMethod.GET)
    public ModelAndView messagesWithOne(@PathVariable("idSender") int idSender,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(ClientURL.getProperty("url.messagesWithOne"));

        List<ShowUnreadedMessage> list =
                messageService.getMessageOneSender(((User)session.getAttribute("user")).getIdUser(),idSender);
        modelAndView.addObject("listMessage", list);
        modelAndView.addObject("idSender", idSender);
        modelAndView.addObject("idReciever",((User)session.getAttribute("user")).getIdUser());
        return modelAndView;
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

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public @ResponseBody
    ShowUnreadedMessage sendMessage(@RequestParam String body,
                                    @RequestParam Integer idSender,
                                    @RequestParam Integer idReciever,
                                    HttpSession session)
    {
        System.out.println("Сообщение "+ body + "Получатель: "+  idReciever+ " Отправитель: " + idSender);
        //-----логика добавления сообщения в базу-------///
        try {
            Message message = new Message();
            message.setDate(new Date());
            message.setContent(body);
            message.setIdUserSender(idSender);
            messageService.sendMessage(message, idReciever);
            ///-----------конец логики добавления в базу--------//
            ShowUnreadedMessage showUnreadedMessage = new ShowUnreadedMessage();
            showUnreadedMessage.setContent(body);
            showUnreadedMessage.setDate(new DateTime());
            showUnreadedMessage.setLogin(((User) session.getAttribute("user")).getLogin());
            return showUnreadedMessage;
        }catch (RestClientException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/go-to-conversation-person/{id}")
    public ModelAndView redirectToConversationWithPerson(@PathVariable("id") int id,
                                                         HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int idReciever = ((User) session.getAttribute("user")).getIdUser();
            String loginReciver = ((User) session.getAttribute("user")).getLogin();
            List<ShowUnreadedMessage> list = messageService.goConversationByPerson(id, idReciever);
            if (list != null) {
                modelAndView.setViewName(ClientURL.getProperty("url.messagesWithOne"));
                modelAndView.addObject("listMessage", list);
                modelAndView.addObject("idReciever", idReciever);
                String login = "";
                for (ShowUnreadedMessage o : list) {
                    if (!o.getLogin().equals(loginReciver)) {
                        login = o.getLogin();
                        break;
                    }
                }
                int idSender = userService.getIdUserByLogin(login);
                modelAndView.addObject("idSender", idSender);
            }else{
                modelAndView.setViewName("redirect:/person-control/showAllPerson");
            }

        } catch (Exception e) {
             modelAndView.setViewName("redirect:/error");
        }
        return modelAndView;
    }
}
