package by.bsuir.ief.corporativ_portal.model.service;

import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

/**
 * Created by andrey on 05.05.2016.
 */
@Component
public class MessageService {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;



}
