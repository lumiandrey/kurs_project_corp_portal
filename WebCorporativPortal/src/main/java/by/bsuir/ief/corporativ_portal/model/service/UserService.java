package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
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
    private static String GET_USER_BY_LOGIN = HOST_URL + ServerURL.getProperty("rest.get.userapi.userlogin");
    private static String GET_USER_AUTORIZEN = HOST_URL + ServerURL.getProperty("rest.post.userapi.autorizen");
    private static String GET_USER_BY_ID_PERSON = HOST_URL + ServerURL.getProperty("rest.get.userapi.useridperson");
    private static String GET_ID_USER_BY_LOGIN = HOST_URL + ServerURL.getProperty("rest.get.userapi.iduserbylogin");
    private static String POST_USER_REGISTRATION = HOST_URL + ServerURL.getProperty("rest.post.userapi.user");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    /**
     *
     * @param login
     * @return
     */
    public User getUserByLogin(String login){
        User user = null;
        try {
             user = template.getForObject(GET_USER_BY_LOGIN, User.class, login);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User autorized(User user) throws Exception
    {
        return template.postForObject(GET_USER_AUTORIZEN, user, User.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public User getUserByIdPerson(int id)
    {
        User user = null;
        try {
            ResponseEntity<User> responseEntity = template.getForEntity(GET_USER_BY_ID_PERSON,User.class,id);
            System.out.println(responseEntity.getStatusCode());
            user = responseEntity.getBody();
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    public boolean registrationUser(User user)
    {
        Boolean okRegistration = false;
        try {
            okRegistration = template.postForObject(POST_USER_REGISTRATION, user, Boolean.class);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return okRegistration;
    }
    public int getIdUserByLogin(String login)
    {
        int idUser = template.getForObject(GET_ID_USER_BY_LOGIN, Integer.class,login);

        return idUser;
    }

}
