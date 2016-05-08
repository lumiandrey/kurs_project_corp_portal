package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Darya on 08.05.16.
 */
@Component
public class RecordService {
    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;


    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_SHOWRECORDS = HOST_URL + ServerURL.getProperty("rest.get.taskapi.listrecords");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public List<Record> getRecords()
    {
        List<Record> list = null;
        try{
            list = template.getForObject(GET_SHOWRECORDS,List.class);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}


