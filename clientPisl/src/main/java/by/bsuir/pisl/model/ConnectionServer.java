package by.bsuir.pisl.model;

import by.bsuir.pisl.model.entity.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.MediaSize;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrey on 19.04.2016.
 */
@Component
public class ConnectionServer {

    @Autowired
    private RestTemplate restTemplate;

    private static String NAME_HOST = "http://localhost:8080/restCorpPortal";
    private static String GET_PERSONS = "/pislrest/persons";
    private static String GET_PERSON_BY_ID = "/pislrest/person/{id}";
    private static String POST_SAVE_OR_UPDATE_PERSON = "/pislrest/personsaveorupdate";
    private static String POST_SAVES_OR_UPDATES_PERSONS = "/pislrest/personsaveorupdates";
    private static String DELETE_PERSON_BY_ID = "/pislrest/person/{id}";
    private static String DELETE_ALL_PERSON = "/pislrest/persons";
    private static String PUT_PERSON = "/pislrest/person";



    public List<PersonPisl> getAllPerson()throws Exception
    {
        PersonPisl[] personPisls = restTemplate.getForObject(NAME_HOST+GET_PERSONS,PersonPisl[].class);
        List<PersonPisl> pislList = new ArrayList<>();
        Collections.addAll(pislList, personPisls);
        return pislList;
    }

    public PersonPisl saveOrUpdate(PersonPisl personPisl)throws Exception { // можно возвращать статус операции
        personPisl = restTemplate.postForObject(NAME_HOST + POST_SAVE_OR_UPDATE_PERSON, personPisl, PersonPisl.class);
        return personPisl;
    }

    public void deletePersonById(int id)throws Exception //тут тоже
    {
        restTemplate.delete(NAME_HOST+DELETE_PERSON_BY_ID,new Integer(id));
    }

    public void allDelete() throws Exception
    {
        restTemplate.delete(new URI(NAME_HOST+DELETE_ALL_PERSON));
    }

    public List<PersonPisl> saveOrUpdate(List<PersonPisl> personPisls)throws Exception
    {
        personPisls = restTemplate.postForObject(NAME_HOST+POST_SAVES_OR_UPDATES_PERSONS,personPisls,List.class);
        return personPisls;
    }

    public void putPerson(PersonPisl personPisl){
        restTemplate.put(NAME_HOST+PUT_PERSON,personPisl);
    }

    public void putPerson(List<PersonPisl> personPisls){
        restTemplate.put(NAME_HOST+PUT_PERSON,personPisls);
    }

}
