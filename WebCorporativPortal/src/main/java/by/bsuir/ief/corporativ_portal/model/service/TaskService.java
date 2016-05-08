package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Task;
import by.bsuir.ief.corporativ_portal.model.entity.views.ShowUnreadedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Darya on 07.05.16.
 */
@Component
public class TaskService {


    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;


    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_SHOWALLTASKS = HOST_URL + ServerURL.getProperty("rest.get.taskapi.listalltasks");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public List<Task> getAllTasks(int idUser)
    {
        List<Task> list = null;
        try{
            list = template.getForObject(GET_SHOWALLTASKS,List.class,idUser);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
