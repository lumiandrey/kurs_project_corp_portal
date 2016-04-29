package by.bsuir.ief.corporativ_portal.model.server;

import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConnectionServer {

    @Autowired
    private RestTemplate restTemplate;

    public Person getPerson(int id) throws Exception {
        //return restTemplate.getForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.get.person.id"), new Integer(id));
        return null;
    }

    public Person createOrUpdatePerson(Person person) throws Exception{
        person = restTemplate.postForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.post.person.createorupdate"), person, Person.class);
        return person;
    }

    public void deletePersonById(int id) throws Exception{
        restTemplate.delete(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.delete.person.id"),new Integer(id));
    }

    public User getUser(int id) throws Exception {
        //return restTemplate.getForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.get.user.id"), new Integer(id));
        return null;
    }

    public User getUserByLogin(String login) throws Exception{
        String uri = ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.get.user.login");
        return restTemplate.getForObject(uri, User.class, login);
    }

    public User createOrUpdateUser(User user) throws Exception{
        user = restTemplate.postForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.post.user.createorupdate"), user, User.class);
        return user;
    }

    public void deleteUserById(int id) throws Exception{
        restTemplate.delete(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.delete.user.id"),new Integer(id));
    }

    public Person getPersonByFIOAndBirthday(Person person) {
        return restTemplate.postForObject(ServerURL.getProperty("rest.hostname") + ServerURL.getProperty("rest.get.person.fio"), person, Person.class);
    }
}
