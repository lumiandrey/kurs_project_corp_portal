package by.bsuir.ief.rest.dao.hibernatedao;

import by.bsuir.ief.rest.dao.DepartmentDAO;
import by.bsuir.ief.rest.model.entity.Department;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Darya on 19.04.16.
 *
 * Класс дао для отделов
 */
@Repository
@Transactional
public class DepartmentHibernate implements DepartmentDAO{

    static final Logger logger = Logger.getLogger(DepartmentHibernate.class);

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;

    private final String hqlfindByIdDepartment = "from PersonPisl where id = :id";

    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Department create(Department createDepartment) throws Exception {
        getCurrentSession().save(createDepartment);
        logger.info("Add entity to db: "+createDepartment);
        return createDepartment;
    }

    @Override
    @Transactional(readOnly=true)
    public List read() throws Exception {
        session = getCurrentSession();
        List<Department> departmentList = session.createCriteria(Department.class).list();
        logger.info("Get entitys " + Department.class);
        return departmentList;
    }

    @Override
    @Transactional(readOnly=true)
    public Department read(int id) throws Exception {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdDepartment);
        query.setParameter("id",new Integer(id));
        Department department = (Department) query.uniqueResult();
        if(department == null )
            throw new EntityNotFoundByIdException(id,Department.class.getName());
        logger.info("Get by id: " +id + " entity: "+department);
        return department;
    }



    @Override
    public Department update(Department updateDepartment) {
        session = getCurrentSession();
        session.update(updateDepartment);
        logger.info("Update entity: "+updateDepartment);
        return updateDepartment;
    }

    @Override
    public void delete(int id) throws Exception {
        session = getCurrentSession();
        Query query = session.createQuery(hqlfindByIdDepartment);
        query.setParameter("id",new Integer(id));
        Department department = (Department) query.uniqueResult();
        if(department == null) {
            throw new EntityNotFoundByIdException(id, Department.class.getName());
        }
        logger.info("Delete by id: " +id+" entity: " + department);
        session.delete(department);
    }
}
