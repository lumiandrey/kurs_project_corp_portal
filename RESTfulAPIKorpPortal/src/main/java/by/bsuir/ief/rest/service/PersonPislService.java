package by.bsuir.ief.rest.service;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.dao.pisl.PersonPislDAOImpl;
import by.bsuir.ief.rest.model.pisl.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@Component
public class PersonPislService {

    @Qualifier("personPislDAOImpl1")
    @Autowired
    private PersonPislDAO personPislDAOImpl1;

    /**
     *
     * @return
     * @throws Exception
     */
    public List<PersonPisl> getAllPerson() throws Exception {

        return personPislDAOImpl1.getEntityList();
    }

    public PersonPisl getPersonByID (int id) throws Exception {
        return personPislDAOImpl1.getEntityById(id);
    }



}
