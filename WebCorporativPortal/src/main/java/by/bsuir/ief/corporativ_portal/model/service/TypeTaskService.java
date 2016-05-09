package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.TypeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Vladislav on 09.05.2016.
 */
@Component
public class TypeTaskService {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate restTemplate;

    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_TYPETASKS = HOST_URL + ServerURL.getProperty("rest.get.typetaskapi.typetasklist");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public List<TypeTask> getTypeTaskList(){
        return restTemplate.getForObject(GET_TYPETASKS,List.class);
    }
}
