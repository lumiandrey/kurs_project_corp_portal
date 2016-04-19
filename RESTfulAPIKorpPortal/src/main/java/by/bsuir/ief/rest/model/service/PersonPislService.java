package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.pisl.PersonPislDAO;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.pisl.*;
import org.apache.log4j.Logger;
import org.jgroups.protocols.PING;
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

    static final Logger logger = Logger.getLogger(PersonPislService.class);

    /**
     *
     * @return
     * @throws Exception
     */
    public List getAllPerson() throws AllEntityNotFountException,BadGetEntityException{
        List personPisls = null;
        try {
            personPisls = personPislDAOImpl1.getEntityList();
            if(personPisls == null)
                throw new AllEntityNotFountException(PersonPisl.class.getName());

        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadGetEntityException(PersonPisl.class.getName(),e);
        }
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public PersonPisl getPersonByID (int id) throws BadGetEntityException, EntityNotFoundByIdException {
        PersonPisl personPisl = null;
        try {
            personPisl = personPislDAOImpl1.getEntityById(id);
        }catch (EntityNotFoundByIdException e){
            logger.info(e);
            throw e;
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadGetEntityException(PersonPisl.class.getName(),e);
        }
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
    public PersonPisl addPerson(PersonPisl personPisl) throws BadAddEntityException {
        try {
            personPisl = personPislDAOImpl1.addEntity(personPisl);
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadAddEntityException(PersonPisl.class.getName(),e);
        }
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     * @throws Exception
     */
    public List addPersons(List<PersonPisl> personPisls) throws BadAddEntityException {
        try {
            personPisls = personPislDAOImpl1.addEntitys(personPisls);
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadAddEntityException(PersonPisl.class.getName(),e);
        }
        return personPisls;
    }

    /**
     *
     * @param personPisl
     * @return
     * @throws Exception
     */
    public PersonPisl updatePerson(PersonPisl personPisl) throws BadUpdateException {
        try {
            personPisl = personPislDAOImpl1.updateEntity(personPisl);
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadUpdateException(PersonPisl.class.getName(),e);
        }
        return personPisl;
    }

    /**
     *
     * @param personPisls
     * @return
     * @throws Exception
     */
    public List updatePersons(List<PersonPisl> personPisls) throws BadUpdateException {
        try {
            personPisls = personPislDAOImpl1.updateEntitys(personPisls);
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadUpdateException(PersonPisl.class.getName(),e);
        }
        return personPisls;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deletePersonById(int id) throws BadDeleteEntityException, EntityNotFoundByIdException {
        boolean deleted = false;
        try {
            deleted = personPislDAOImpl1.deleteEntity(id);
        }catch (EntityNotFoundByIdException e ){
            logger.info(e);
            throw e;
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadDeleteEntityException("Delete by id" + id, PersonPisl.class.getName(),e);
        }
        return deleted;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean deleteAllPerson() throws BadDeleteEntityException {
        boolean deleted = false;
        try {
            deleted = personPislDAOImpl1.deleteAllEntity();
        } catch (Exception e) {
            logger.warn("Error!!! "+e);
            throw new BadDeleteEntityException("Delete all", PersonPisl.class.getName(),e);
        }
        return deleted;
    }

}
