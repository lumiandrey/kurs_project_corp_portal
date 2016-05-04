package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.Post;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrey on 02.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dbunit.xml")
public class DBPostTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PostService service;

    private Post post = null;

    private static int find_id = 0;

    @Before
    public void init()
    {
        post = new Post();
        post.setIdPost(0);
        post.setIncome(1);
        post.setNamePost("root");
        post.setRang("root");
        post.setWorkingSchedule("root");

        find_id = 1;
    }

    @Test
    public void createTest() throws BadAddEntityException {
        Post post1 = service.add(post);
        assertNotNull(post1);
    }

    @Test
    public void readAllTest() throws BadGetEntityException, AllEntityNotFountException {
        List<Post> list = service.read();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void readById()
    {
        Post o = null;
        try {
            o = service.read(find_id);
        } catch (EntityNotFoundByIdException | BadGetEntityException e) {
            e.printStackTrace();
        }
        assertNotNull(o);
    }

    @Test
    public void updateEntity() throws BadGetEntityException, EntityNotFoundByIdException, CloneNotSupportedException, BadUpdateException {
        Post o = service.read(find_id);
        Post clone = (Post) o.clone();
        o.setNamePost("robyn good");
        o = service.update(o);
        assertTrue(o.hashCode() != clone.hashCode());
    }

    @Test
    public void deleteEntityById() throws EntityNotFoundByIdException, BadDeleteEntityException {
        boolean delete = service.delete(1);
        assertTrue("good delete!",delete);
    }

}
