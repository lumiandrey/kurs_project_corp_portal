package by.bsuir.ief.corporativ_portal.model.service;

import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.server.ConnectionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceManager {

    @Autowired
    private ConnectionServer connectionServer;

    public Person getPerson(Person person){
        return connectionServer.getPerson(person.getIdPerson());
    }

    public Person createPerson(Person person){
        return connectionServer.createOrUpdatePerson(person);
    }

    public Person updatePerson(Person person){
        return connectionServer.createOrUpdatePerson(person);
    }

    public void deletePerson(Person person){
        connectionServer.deletePersonById(person.getIdPerson());
    }
}
