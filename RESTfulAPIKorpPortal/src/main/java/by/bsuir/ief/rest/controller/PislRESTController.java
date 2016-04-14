package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.util.Status;
import by.bsuir.ief.rest.model.pisl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
@RestController
@RequestMapping("/pislrest")
public class PislRESTController {


    @Qualifier("personPislDAOImpl1")
    @Autowired
    private PersonPislDAO personPislDAOImpl1;

    ///////////////////GET METHOD/////////////////////
    /**
     *
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<PersonPisl> getAllPerson()
    {
        List<PersonPisl> personPisls = null;
        try {
            personPisls = personPislDAOImpl1.getEntityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public PersonPisl getPersonByID(int id)
    {
        PersonPisl personPisl = null;
        try {
            personPisl = personPislDAOImpl1.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personPisl;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/defaultperson", method = RequestMethod.GET)
    public PersonPisl getDefaultPerson()
    {
        PersonPisl personPisl = new PersonPisl();
        personPisl.setAddressResidence("beiker? street");
        personPisl.setAdressLiving(Cities.Amsterdam);
        personPisl.setBirthday(new java.util.Date());
        personPisl.setCityResidence(Cities.Bitebsk);
        personPisl.setDateGivePasport(new java.util.Date());
        personPisl.setDisability(Disability.Not);
        personPisl.seteMail("huawei-9@mail.ru");
        personPisl.setFirstName("Martynenko");
        personPisl.setHphone("+375175031560");
        personPisl.setIdentifyNumber("1234-1234-1234-1234KB");
        personPisl.setLastName("Yurevitch");
        personPisl.setMaritalStatus(MaritalStatus.Not);
        personPisl.setMonthlyIncome(200.5);
        personPisl.setMphone("+375293736660");
        personPisl.setName("Andrey");
        personPisl.setNationality(Nationality.Belarus);
        personPisl.setOrganizationGivePassport("ROVD Minskoy Oblasti");
        personPisl.setPasportNumber("KR2032");
        personPisl.setPensioner(false);
        personPisl.setPlaceOfBirth("Mogilev");
        personPisl.setPost("IT-Engeniireng");
        personPisl.setReservist(true);
        personPisl.setSerialPasport("KR");
        personPisl.setSex("Men");
        personPisl.setWorkingPlace("Absolute Soft BSUIR");
        return personPisl;
    }

    ///////////////////PUT METHOD/////////////////////
    /**
     *
     * @param personPisl
     * @return
     */
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public PersonPisl putPerson(PersonPisl personPisl)
    {
        try {
            personPisl = personPislDAOImpl1.addEntity(personPisl);
            return personPisl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.PUT)
    public List<PersonPisl> putListPersonPisl(List<PersonPisl> personPisls)
    {
        List<PersonPisl> pisls= null;
        try {
            pisls = personPislDAOImpl1.addEntitys(personPisls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pisls;
    }

    ///////////////////POST METHOD/////////////////////

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public PersonPisl addPerson(PersonPisl personPisl)
    {
        try {
            personPisl = personPislDAOImpl1.addEntity(personPisl);
        } catch (Exception e) {
            e.printStackTrace();
            personPisl = null;
        }
        return personPisl;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public List<PersonPisl> addPersons(List<PersonPisl> personPisls)
    {
        try {
            personPisls = personPislDAOImpl1.addEntitys(personPisls);
        } catch (Exception e) {
            e.printStackTrace();
            personPisls = null;
        }
        return personPisls;
    }
    ///////////////////DELETE METHOD/////////////////////

    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    public Status deletePersonById(int id)
    {
        try {
            personPislDAOImpl1.deleteEntity(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(400, e.toString());
        }
        return new Status(200,"Good delete to Server!");
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    public Status deletePersonByEntity(PersonPisl personPisl)
    {
        try {
            personPislDAOImpl1.deleteEntity(personPisl);
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
        return new Status(200,"Good delete to Server!");
    }

    @RequestMapping (value = "/persons", method = RequestMethod.DELETE)
    public Status deletePersons()
    {
        try {
            personPislDAOImpl1.deleteAllEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(400,e.toString());
        }
        return new Status(200,"Good all delete Persons");
    }


}
