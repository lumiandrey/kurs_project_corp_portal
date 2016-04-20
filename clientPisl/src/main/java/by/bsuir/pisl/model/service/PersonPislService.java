package by.bsuir.pisl.model.service;

import by.bsuir.pisl.model.ConnectionServer;
import by.bsuir.pisl.model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * Created by andrey on 20.04.2016.
 */
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
