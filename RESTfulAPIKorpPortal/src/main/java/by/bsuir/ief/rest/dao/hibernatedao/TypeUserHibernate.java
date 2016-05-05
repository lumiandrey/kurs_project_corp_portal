package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.TypeUserDAO;
import by.bsuir.ief.rest.model.entity.TypeUser;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by andrey on 27.04.2016.
 */
@Repository
@Transactional
public class TypeUserHibernate implements TypeUserDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private final String HQL_FIND_BY_ID_TYPE_USER = "from TypeUser where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public TypeUser create(TypeUser typeUser) throws Exception {
        getCurrentSession().save(typeUser);
        return typeUser;
    }

    @Override
    @Transactional(readOnly=true)
    public List<TypeUser> read() throws AllEntityNotFountException {
        List<TypeUser> typeUsers = getCurrentSession().createCriteria(TypeUser.class).list();
        if(typeUsers == null)
            throw new AllEntityNotFountException(TypeUser.class.toString());
        return typeUsers;
    }

    @Override
    @Transactional(readOnly=true)
    public TypeUser read(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TYPE_USER);
        query.setParameter("id", id);
        TypeUser typeUser = (TypeUser) query.uniqueResult();
        if(typeUser == null )
            throw new EntityNotFoundByIdException(id,TypeUser.class.getName());
        return typeUser;
    }

    @Override
    public TypeUser update(TypeUser typeUser) throws Exception {
        getCurrentSession().update(typeUser);
        return typeUser;
    }

    @Override
    public boolean delete(int id) throws EntityNotFoundByIdException {
        Session session = getCurrentSession();
        Query query = session.createQuery(HQL_FIND_BY_ID_TYPE_USER);
        query.setParameter("id", id);
        TypeUser typeUser = (TypeUser) query.uniqueResult();
        if(typeUser == null) {
            throw new EntityNotFoundByIdException(id, TypeUser.class.getName());
        }
        session.delete(typeUser);
        return true;
    }
}
