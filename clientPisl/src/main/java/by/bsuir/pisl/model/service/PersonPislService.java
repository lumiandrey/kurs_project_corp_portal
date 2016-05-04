package by.bsuir.pisl.model.service;

import by.bsuir.pisl.model.ConnectionServer;
import by.bsuir.pisl.model.data.PersonPislDAO;
import by.bsuir.pisl.model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 20.04.2016.
 */
@Component
public class PersonPislService {

    @Autowired
    private ConnectionServer server;
    @Autowired
    private volatile PersonPislDAO personPislDAO;


    public synchronized List<PersonPisl> getPersonPisls() throws Exception
    {
        return personPislDAO.getEntityList();
    }

    public synchronized List<PersonPisl> getPersonPislsToServer() throws Exception
    {
        return server.getAllPerson();
    }

    public PersonPisl saveOrUpdate(PersonPisl personPisl,boolean statusConnection) throws Exception {
        if(statusConnection)
            server.saveOrUpdate(personPisl);
        return personPislDAO.saveOrUpdates(personPisl);
    }

    public PersonPisl save(PersonPisl personPisl, boolean statusConnection) throws Exception {
        if(statusConnection)
            server.save(personPisl);
        return personPislDAO.addEntity(personPisl);
    }

    public List<PersonPisl> save(List<PersonPisl> personPisl, boolean statusConnection) throws Exception {
        if(statusConnection)
            server.save(personPisl);
        return personPislDAO.addEntitys(personPisl);
    }

    public PersonPisl update(PersonPisl personPisl, boolean statusConnection) throws Exception {
        if(statusConnection)
            server.saveOrUpdate(personPisl);
        return personPislDAO.updateEntity(personPisl);
    }

    public void deleteById(int id,boolean statusConnection) throws Exception {
        if(statusConnection)
            server.deletePersonById(id);
        personPislDAO.deleteEntity(id);

    }

    public void alldelete(boolean statusConnection) throws Exception {
        if(statusConnection)
            server.allDelete();
        personPislDAO.deleteAllEntity();

    }

    public void getStstusServer()
    {
        server.getStatus();
    }





}
