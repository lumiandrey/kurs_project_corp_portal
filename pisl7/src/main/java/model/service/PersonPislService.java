package model.service;

import model.ConnectionServer;
import model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PersonPislService {

    @Autowired
    private ConnectionServer server;

    public List<PersonPisl> getPersonPisls() throws Exception
    {
        return server.getAllPerson();
    }

    public PersonPisl saveOrUpdate(PersonPisl personPisl) throws Exception {
        return server.saveOrUpdate(personPisl);
    }

    public void deleteById(int id) throws Exception {
        server.deletePersonById(id);
    }


}
