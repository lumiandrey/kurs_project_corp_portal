package by.bsuir.ief.corporativ_portal.model.server;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConnectionServer {

    @Autowired
    private RestTemplate restTemplate;

    public Person getPerson(int id) {
        //return restTemplate.getForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.get.person.id"), new Integer(id));
        return null;
    }

    public Person createOrUpdatePerson(Person person){
        person = restTemplate.postForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.post.person.createorupdate"), person, Person.class);
        return person;
    }

    public void deletePersonById(int id){
        restTemplate.delete(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.delete.person.id"),new Integer(id));
    }
}
