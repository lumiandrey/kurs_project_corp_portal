package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Message;
import by.bsuir.ief.corporativ_portal.model.entity.views.ShowUnreadedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by andrey on 05.05.2016.
 */
@Component
public class MessageService {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;


    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_SHOWUNREADEDMESSAGES = HOST_URL + ServerURL.getProperty("rest.get.messageapi.messageunreaded");
    private static String GET_MESSAGEONESENDER = HOST_URL + ServerURL.getProperty("rest.get.messageapi.messageonesender");
    private static String POST_SEND_MESSAGE = HOST_URL + ServerURL.getProperty("rest.post.messageapi.send");

    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public List<ShowUnreadedMessage> getUnreadedMessage(int idUser)
    {
        List<ShowUnreadedMessage> list = null;
        try{
            list = template.getForObject(GET_SHOWUNREADEDMESSAGES,List.class,idUser);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        System.out.println(list);

        return list;
    }

    public List<ShowUnreadedMessage> getMessageOneSender(int idReciver, int idSenser)
    {
        List<ShowUnreadedMessage> list = null;
        try{
            list = template.getForObject(GET_MESSAGEONESENDER,List.class,idSenser,idReciver);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return list;
    }


    public Message sendMessage(Message message, int idReciver)
    {
        return template.postForObject(POST_SEND_MESSAGE,message,Message.class,idReciver);
    }

}
