package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by andrey on 04.05.2016.
 */
@Component
public class UserService {


    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;

    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_USER_BY_LOGIN = HOST_URL + ServerURL.getProperty("rest.get.user.login");
    private static String GET_USER_AUTORIZEN = HOST_URL + ServerURL.getProperty("rest.post.userapi.autorizen");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//


    public User getUserByLogin(String login) throws Exception{
        return template.getForObject(GET_USER_BY_LOGIN, User.class, login);
    }

    public User autorized(User user) throws Exception
    {
        return template.postForObject(GET_USER_AUTORIZEN, user, User.class);
    }
}
