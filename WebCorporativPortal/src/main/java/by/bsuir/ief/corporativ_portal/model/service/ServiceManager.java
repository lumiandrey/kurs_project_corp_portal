package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.entity.User;
import by.bsuir.ief.corporativ_portal.model.server.ConnectionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceManager {

    @Autowired
    private ConnectionServer connectionServer;

    public Person getPerson(Person person)  throws Exception{
        return connectionServer.getPerson(person.getIdPerson());
    }

    public Person createPerson(Person person) throws Exception{
        return connectionServer.createOrUpdatePerson(person);
    }

    public Person updatePerson(Person person) throws Exception{
        return connectionServer.createOrUpdatePerson(person);
    }

    public void deletePerson(Person person) throws Exception{
        connectionServer.deletePersonById(person.getIdPerson());
    }

    public User getUser(User user) throws Exception{
        return connectionServer.getUser(user.getIdUser());
    }

    public User createUser(User user) throws Exception{
        return connectionServer.createOrUpdateUser(user);
    }

    public User updateUser(User user) throws Exception{
        return connectionServer.createOrUpdateUser(user);
    }

    public void deleteUser(User user) throws Exception{
        connectionServer.deleteUserById(user.getIdUser());
    }

    public User getUserByLogin(User user) throws Exception{
        return connectionServer.getUserByLogin(user.getLogin());
    }

    public Person getPersonByFIO(Person person) {
        return connectionServer.getPersonByFIOAndBirthday(person);
    }
}
