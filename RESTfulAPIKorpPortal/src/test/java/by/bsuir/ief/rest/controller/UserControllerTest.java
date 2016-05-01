package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.User;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by andrey on 01.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationCot.xml")
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private UserController controller;

    @Test
    public void getById()
    {
        User user = null;
        user = controller.getUserById(1);
        assertNotNull(user);
    }

    @Test
    public void getUsers()
    {
        List<User> list = null;
        list = controller.getUsers();
        assertNotNull(list);
    }

    @Test
    public void createUser() throws BadGetEntityException, EntityNotFoundByIdException, BadAddEntityException {
        User user = null;
        user = controller.getUserById(1);
        user.setLogin("boot");
        user.setPassword("boot");
        user.setIdUser(0);
        controller.registration(user);
    }


    @Test
    public void update() throws BadGetEntityException, EntityNotFoundByIdException, BadUpdateException {
        User user = null;
        user = controller.getUserById(1);
        User updateUser = controller.getUserById(1);
        updateUser.setLogin("roby");
        updateUser = controller.putUser(user);
        assertEquals(user,updateUser);
    }

    @Test
    public void autorization() {
        User user = new User();
        user = controller.getUserById(1);
        controller.autorization(user);
    }

    @Test
    public void deleteUserById() throws EntityNotFoundByIdException, BadDeleteEntityException {
        controller.deletePersonById(1);
    }

}
