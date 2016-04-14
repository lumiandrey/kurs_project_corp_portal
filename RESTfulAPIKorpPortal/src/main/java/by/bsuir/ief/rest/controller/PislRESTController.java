package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.util.Status;
import by.bsuir.ief.rest.model.pisl.*;
import by.bsuir.ief.rest.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public PersonPisl getPersonByID(@PathVariable("id") int id)
    {
        PersonPisl personPisl = null;
        try {
            personPisl = personPislDAOImpl1.getEntityById(id);
        } catch (UserNotFoundException e){
            throw e;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return personPisl;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/defaultpersonandrey", method = RequestMethod.GET)
    public PersonPisl getDefaultPersonAndrey()
    {
        PersonPisl personPisl = new PersonPisl();
        personPisl.setAddressResidence("beiker street");
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

    /**
     *
     * @return
     */
    @RequestMapping(value = "/defaultpersondarya", method = RequestMethod.GET)
    public PersonPisl getDefaultPersonDarya()
    {
        PersonPisl personPisl = new PersonPisl();
        personPisl.setAddressResidence("Wow street");
        personPisl.setAdressLiving(Cities.Budapest);
        personPisl.setBirthday(new java.util.Date());
        personPisl.setCityResidence(Cities.Minsk);
        personPisl.setDateGivePasport(new java.util.Date());
        personPisl.setDisability(Disability.Not);
        personPisl.seteMail("ssemmikina@gmail.com");
        personPisl.setFirstName("Semikina");
        personPisl.setHphone("+375175896420");
        personPisl.setIdentifyNumber("1234-1234-1234-5246KB");
        personPisl.setLastName("Sergeevna");
        personPisl.setMaritalStatus(MaritalStatus.Not);
        personPisl.setMonthlyIncome(350.5);
        personPisl.setMphone("+3752962520100");
        personPisl.setName("Darya");
        personPisl.setNationality(Nationality.Belarus);
        personPisl.setOrganizationGivePassport("ROVD Minskoy Oblasti");
        personPisl.setPasportNumber("KR2032");
        personPisl.setPensioner(false);
        personPisl.setPlaceOfBirth("Minsk");
        personPisl.setPost("Big Data analysis");
        personPisl.setReservist(true);
        personPisl.setSerialPasport("KR");
        personPisl.setSex("Woman");
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
    public PersonPisl putPerson(@RequestBody PersonPisl personPisl)
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
    public List<PersonPisl> putListPersonPisl(@RequestBody List<PersonPisl> personPisls)
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
    public PersonPisl addPerson(@RequestBody PersonPisl personPisl)
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
    public List<PersonPisl> addPersons(@RequestBody List<PersonPisl> personPisls)
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
    public Status deletePersonById(@PathVariable("id")int id)
    {
        try {
            personPislDAOImpl1.deleteEntity(id);
        } catch (Exception e) {
            e.printStackTrace();
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
