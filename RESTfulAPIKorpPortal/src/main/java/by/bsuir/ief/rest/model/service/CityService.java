package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.CityDAO;
import by.bsuir.ief.rest.model.entity.City;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Component
public class CityService {

    @Qualifier("cityHibernate")
    @Autowired
    private CityDAO cityHibernate;

    /**
     *
     * @param city
     * @return
     * @throws BadAddEntityException
     */
    public City add(City city) throws BadAddEntityException {
        try {
            city = cityHibernate.create(city);
        } catch (Exception e) {
            throw new BadAddEntityException(City.class.toString(),e);
        }
        return city;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public City read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        City comment = null;
        try {
            comment = cityHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(City.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<City> read() throws AllEntityNotFountException, BadGetEntityException {
        List<City> list = null;
        try {
            list = cityHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(City.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param idCountry
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<City> readCityByIdCountry(int idCountry) throws AllEntityNotFountException, BadGetEntityException {
        List<City> list = null;
        try {
            list = cityHibernate.readCityByIdCountry(idCountry);
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(City.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param comment
     * @return
     * @throws BadUpdateException
     */
    public City update(City comment) throws BadUpdateException {
        try {
            comment = cityHibernate.update(comment);
        } catch (Exception e) {
            throw  new BadUpdateException(City.class.toString(),e);
        }
        return comment;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            cityHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(), City.class.toString(),e);
        }
    }
}
