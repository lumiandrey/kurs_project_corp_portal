package by.bsuir.ief.rest.service;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.model.pisl.*;
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
    public List getAllPerson() throws Exception {
        List personPisls = null;
        personPisls = personPislDAOImpl1.getEntityList();
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public PersonPisl getPersonByID (int id) throws Exception {
        PersonPisl personPisl = null;
        personPisl = personPislDAOImpl1.getEntityById(id);
        return personPisl;
    }

    /**
     *
     * @param name
     * @return
     */
    public PersonPisl getDefaultPerson(String name)
    {
        PersonPisl personPisl = new PersonPisl();
        personPisl.setAddressResidence("beiker street");
        personPisl.setAdressLiving(Cities.Amsterdam);
        personPisl.setBirthday(new java.util.Date());
        personPisl.setCityResidence(Cities.Bitebsk);
        personPisl.setDateGivePasport(new java.util.Date());
        personPisl.setDisability(Disability.Not);
        personPisl.seteMail("defaultmail@uncown.rand");
        personPisl.setFirstName(name);
        personPisl.setHphone("+375(xx)xxx-xx-xx");
        personPisl.setIdentifyNumber("1111-1111-1111-1111XX");
        personPisl.setLastName(name);
        personPisl.setMaritalStatus(MaritalStatus.Not);
        personPisl.setMonthlyIncome(200.5);
        personPisl.setMphone("+375(xx)xxx-xx-xx");
        personPisl.setName(name);
        personPisl.setNationality(Nationality.Belarus);
        personPisl.setOrganizationGivePassport("XXXX Xxxxxx Xxxxxx");
        personPisl.setPasportNumber("XX1111");
        personPisl.setPensioner(false);
        personPisl.setPlaceOfBirth("XXXXXXX");
        personPisl.setPost("XX-XXXXXXXX");
        personPisl.setReservist(true);
        personPisl.setSerialPasport("XX");
        personPisl.setSex("XXX");
        personPisl.setWorkingPlace("XXXXXX");
        return personPisl;
    }

    /**
     *
     * @param personPisl
     * @return
     * @throws Exception
     */
    public PersonPisl addPerson(PersonPisl personPisl) throws Exception {
        personPisl = personPislDAOImpl1.addEntity(personPisl);
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     * @throws Exception
     */
    public List addPersons(List<PersonPisl> personPisls) throws Exception {
        personPisls = personPislDAOImpl1.addEntitys(personPisls);
        return personPisls;
    }

    /**
     *
     * @param personPisl
     * @return
     * @throws Exception
     */
    public PersonPisl updatePerson(PersonPisl personPisl) throws Exception {
        personPisl = personPislDAOImpl1.addEntity(personPisl);
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     * @throws Exception
     */
    public List updatePersons(List<PersonPisl> personPisls) throws Exception {
        personPisls = personPislDAOImpl1.addEntitys(personPisls);
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deletePersonById(int id) throws Exception {
        boolean deleted = personPislDAOImpl1.deleteEntity(id);
        return deleted;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean deleteAllPerson() throws Exception {
        boolean deleted = personPislDAOImpl1.deleteAllEntity();
        return deleted;
    }

}
