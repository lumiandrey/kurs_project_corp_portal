package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.TypeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Darya on 07.05.16.
 */
@Component
public class TypeUserService {


    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate restTemplate;

    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_TYPEUSER_BY_ID = HOST_URL + ServerURL.getProperty("rest.get.typeuserapi.typeuserbyid");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public TypeUser getTypeUserById(int id)
    {
        TypeUser typeUser = null;
        try {
            typeUser = restTemplate.getForObject(GET_TYPEUSER_BY_ID, TypeUser.class, id);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return typeUser;
    }
}
