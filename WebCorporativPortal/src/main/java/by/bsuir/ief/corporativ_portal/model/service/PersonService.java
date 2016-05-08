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

import java.util.List;

/**
 * Created by Darya on 05.05.16.
 */
@Component
public class PersonService {


    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;

    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String PUT_PERSON = HOST_URL + ServerURL.getProperty("rest.put.personapi.person");
    private static String POST_PERSON_FIO = HOST_URL + ServerURL.getProperty("rest.post.personapi.personfio");
    private static String GET_PERSONS = HOST_URL + ServerURL.getProperty("rest.get.personapi.persons");
    private static String GET_PERSONS_SORT = HOST_URL + ServerURL.getProperty("rest.get.personapi.personssort");
    //--------------------END URL CONNECTION TO SERVER-------------------------------//

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

    public List<Person> getPersons()
    {
        List<Person> list = null;
        try{
            list = template.getForObject(GET_PERSONS,List.class);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return list;
    }



    public List<Person> getPersonsSorted()
    {
        List<Person> list = null;
        try{
            list = template.getForObject(GET_PERSONS_SORT,List.class);
        }catch (RestClientException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

}
