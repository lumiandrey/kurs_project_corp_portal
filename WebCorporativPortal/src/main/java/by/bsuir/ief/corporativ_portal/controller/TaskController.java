package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Task;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.service.MessageService;
import by.bsuir.ief.corporativ_portal.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Darya on 07.05.16.
 */
@Controller
@RequestMapping("/tasks")

public class TaskController {

    @Qualifier("taskService")
    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/listTasks", method = RequestMethod.GET)
    public ModelAndView listTasks(HttpSession session)
    {
        List<Task> listTasks = taskService.getAllTasks (((User)session.getAttribute("user")).getPerson().getIdPerson());
        return new ModelAndView(ClientURL.getProperty("url.listTasks"), "listTasks", listTasks);
    }



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
