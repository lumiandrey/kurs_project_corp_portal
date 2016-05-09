package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Task;
import by.bsuir.ief.rest.model.entity.TypeTask;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.TaskService;
import by.bsuir.ief.rest.model.service.TypeTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Vladislav on 09.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class DBTaskTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private TaskService taskService;
    @Autowired
    private TypeTaskService typeTaskService;


    @Test
    public void createTest() throws BadAddEntityException, BadGetEntityException, EntityNotFoundByIdException {
        Task add = new Task();
        TypeTask typeTask = typeTaskService.read(2);
        add.getType_pask().setIdTypeTask(2);
        add = taskService.addTaskByPerson(add, 3);
        assertNotNull(add);
    }

}
