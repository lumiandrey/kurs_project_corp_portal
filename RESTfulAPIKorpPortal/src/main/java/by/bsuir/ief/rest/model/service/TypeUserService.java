package by.bsuir.ief.rest.model.service;


import by.bsuir.ief.rest.dao.hibernatedao.TypeUserHibernate;
import by.bsuir.ief.rest.model.entity.TypeUser;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Darya on 27.04.16.
 */
public class TypeUserService {
    @Qualifier("typeUserService")
    @Autowired
    private TypeUserHibernate typeUserHibernate;

    /**
     *
     * @param typeUser
     * @return
     * @throws BadAddEntityException
     */
    public TypeUser add(TypeUser typeUser) throws BadAddEntityException {
        try {
            typeUser = typeUserHibernate.create(typeUser);
        } catch (Exception e) {
            throw new BadAddEntityException(TypeUser.class.toString(),e);
        }
        return typeUser;
    }

    /**
     *
     * @param id
     * @return
     * @throws EntityNotFoundByIdException
     * @throws BadGetEntityException
     */
    public TypeUser read(int id) throws EntityNotFoundByIdException, BadGetEntityException {
        TypeUser person = null;
        try {
            person = typeUserHibernate.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadGetEntityException(TypeUser.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @return
     * @throws AllEntityNotFountException
     * @throws BadGetEntityException
     */
    public List<TypeUser> read() throws AllEntityNotFountException, BadGetEntityException {
        List<TypeUser> list = null;
        try {
            list = typeUserHibernate.read();
        } catch (AllEntityNotFountException e) {
            throw e;
        } catch (Exception e) {
            throw new BadGetEntityException(TypeUser.class.toString(),e);
        }
        return list;
    }

    /**
     *
     * @param
     * @return
     * @throws BadUpdateException
     */
    public TypeUser update(TypeUser person) throws BadUpdateException {
        try {
            person = typeUserHibernate.update(person);
        } catch (Exception e) {
            throw  new BadUpdateException(TypeUser.class.toString(),e);
        }
        return person;
    }

    /**
     *
     * @param id
     * @throws EntityNotFoundByIdException
     * @throws BadDeleteEntityException
     */
    public void delete(int id) throws EntityNotFoundByIdException, BadDeleteEntityException {
        try {
            typeUserHibernate.delete(id);
        } catch (EntityNotFoundByIdException e) {
            throw e;
        }catch (Exception e) {
            throw new BadDeleteEntityException(e.getMessage(),TypeUser.class.toString(),e);
        }
    }

}
