package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Darya on 05.05.16.
 */
@Component
public class PersonService {


    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String PUT_PERSON = HOST_URL + ServerURL.getProperty("rest.put.personapi.person");
    private static String POST_PERSON_FIO = HOST_URL + ServerURL.getProperty("rest.post.personapi.personfio");


    public void update(Person person) throws Exception
    {
        template.put(PUT_PERSON,person);
    }

    public Person getByFIO(Person person) {
        Person person1 = null;
        try {
            person1 = template.postForObject(POST_PERSON_FIO, person, Person.class);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return person1;
    }

}
