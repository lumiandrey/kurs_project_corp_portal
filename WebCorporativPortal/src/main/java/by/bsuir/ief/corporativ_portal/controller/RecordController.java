package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Comment;
import by.bsuir.ief.corporativ_portal.model.entity.Record;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.corporativ_portal.model.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Darya on 08.05.16.
 */

@Controller
@RequestMapping("/records")
public class RecordController {

    @Qualifier("recordService")
    @Autowired
    private RecordService recordService;


    @RequestMapping(value = "/listRecords", method = RequestMethod.GET)
    public ModelAndView listTasks(HttpSession session)
    {
        List<Record> listTasks = recordService.getRecords();
        return new ModelAndView(ClientURL.getProperty("url.newsList"), "newsList", listTasks);
    }

/*

    @RequestMapping(value = "/recordWithComment/{idRecord}", method = RequestMethod.GET)
    public ModelAndView messagesWithOne(@PathVariable("idRecord") int idRecord,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(ClientURL.getProperty("url.messagesWithOne"));
        List<Comment> list = recordService.getCommentsOneMessages(((User)session.getAttribute("user")).getIdUser(),idRecord);
        modelAndView.addObject("listMessage", list);
        return modelAndView;
    }
*/

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(ClientURL.getProperty("url.listTasks"));
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user);
            /*Список непрочитанных сообщений*/

        return modelAndView;
    }




}
