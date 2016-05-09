package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.Task;
import by.bsuir.ief.corporativ_portal.model.entity.TypeTask;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.service.MessageService;
import by.bsuir.ief.corporativ_portal.model.service.TaskService;
import by.bsuir.ief.corporativ_portal.model.service.TypeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    @Qualifier("typeTaskService")
    @Autowired
    private TypeTaskService typeTaskService;


    @RequestMapping(value = "/listTasks", method = RequestMethod.GET)
    public ModelAndView listTasks(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Task> listTasks = taskService.getAllTasks (((User)session.getAttribute("user")).getPerson().getIdPerson());
        List<TypeTask> typeTaskList = typeTaskService.getTypeTaskList();
        modelAndView.setViewName(ClientURL.getProperty("url.listTasks"));
        modelAndView.addObject("typeTaskList", typeTaskList);
        modelAndView.addObject("listTasks", listTasks);
        modelAndView.addObject("newTask", new Task());
        modelAndView.addObject("idCreated", ((User)session.getAttribute("user")).getPerson().getIdPerson());
        return modelAndView;
    }

    @RequestMapping(value = "/createTask/{idCreated}", method = RequestMethod.POST)
    public String createdTask(@Valid @ModelAttribute("newTask")Task task,
                                    @RequestParam int typeTasks,
                                    @PathVariable("idCreated") int idCreated,
                                    ModelMap modelMap, HttpSession session)
    {
        task.getType_pask().setIdTypeTask(typeTasks);
        task = taskService.addTask(task, idCreated);
        return "redirect:/tasks/listTasks";
    }


}
