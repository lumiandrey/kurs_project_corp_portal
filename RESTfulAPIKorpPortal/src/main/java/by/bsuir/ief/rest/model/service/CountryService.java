package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.hibernatedao.CountryHibernate;
import by.bsuir.ief.rest.model.entity.Country;
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
public class CountryService {
    @Qualifier("countryHibernate")
    @Autowired
    private CountryHibernate countryHibernate;

    /**
     *
     * @param country
     * @return
     * @throws BadAddEntityException
     */
    public Country add(Country country) throws BadAddEntityException {
        try {
            country = countryHibernate.create(country);
        } catch (Exception e) {
            throw new BadAddEntityException(Country.class.toString(),e);
        }
        return country;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public Country read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        Country country = null;
        try {
            country = countryHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(Country.class.toString(),e);
        }
        return country;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<Country> read() throws AllEntityNotFountException, BadGetEntityException {
        List<Country> list = null;
        try {
            list = countryHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(Country.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param country
     * @return
     * @throws BadUpdateException
     */
    public Country update(Country country) throws BadUpdateException {
        try {
            country = countryHibernate.update(country);
        } catch (Exception e) {
            throw  new BadUpdateException(Country.class.toString(),e);
        }
        return country;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            countryHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),Country.class.toString(),e);
        }
    }
}
