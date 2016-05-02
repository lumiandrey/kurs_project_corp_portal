package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByParametrsException;
import by.bsuir.ief.rest.model.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by andrey on 01.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class DBUserTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UsersService service;

    @Test
    public void readById() throws BadGetEntityException, EntityNotFoundByIdException {
        User user = null;
        user = service.read(1);
        assertNotNull(user);
    }

    @Test
    public void readUsers() throws BadGetEntityException, AllEntityNotFountException {
        List<User> users = null;
        users = service.read();
        assertNotNull(users);
    }

    @Test
    public void createUser() throws BadGetEntityException, EntityNotFoundByIdException, BadAddEntityException {
        User user = null;
        user = service.read(1);
        user.setLogin("boot");
        user.setPassword("boot");
        user.setIdUser(0);
        user = service.add(user);
        assertNotNull(user);
    }

    @Test
    public void readByLogin() throws BadGetEntityException, EntityNotFoundByParametrsException {
        User user = null;
        user = service.getUserByLogin("root");
        assertNotNull(user);
    }

    @Test
    public void readByLoginAndPassword() throws BadGetEntityException, EntityNotFoundByParametrsException {
        User user = new User();
        user.setLogin("root");
        user.setPassword("root");
        user = service.autorizen(user);
        assertNotNull(user);
    }

    @Test
    public void update() throws BadGetEntityException, EntityNotFoundByIdException, BadUpdateException, CloneNotSupportedException {
        User user = service.read(1);
        User updateUser = (User) user.clone();
        user.setLogin("roby");
        user = service.update(user);
        assertTrue(user.hashCode() != updateUser.hashCode());
    }

    @Test
    public void deleteUserById() throws EntityNotFoundByIdException, BadDeleteEntityException {
        boolean delete = service.delete(1);
        assertTrue("good delete!",delete);
    }

    @Test
    public void failDelete()
    {
        try {
            boolean delete = service.delete(-1);
        } catch (EntityNotFoundByIdException | BadDeleteEntityException e) {
        }
        fail("no id failed!!!");
    }

    @Test
    public void deleteByLogin()
    {
        boolean delete = false;
        try {
            delete = service.delete("root");
            assertTrue("good delete!",delete);
        } catch (EntityNotFoundByParametrsException | BadDeleteEntityException e) {
            e.printStackTrace();
        }
    }

}
