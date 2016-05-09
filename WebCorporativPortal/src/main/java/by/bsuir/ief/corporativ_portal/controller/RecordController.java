package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.*;
import by.bsuir.ief.corporativ_portal.model.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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


    @RequestMapping(value = "/sendComment/{idRecord}", method = RequestMethod.POST)
    public String updatePerson(@PathVariable("idRecord")int idRecord, @RequestParam String content, HttpSession session ) throws Exception {

        Comment comment = new Comment();
        comment.setRecord(idRecord);
        comment.setDate(new Date());
        comment.setContent(content);
        comment.setIduser(((User)session.getAttribute("user")).getIdUser());
        recordService.sendCommentToRecord(comment);
        return ClientURL.getProperty("url.newsList");
    }

}
