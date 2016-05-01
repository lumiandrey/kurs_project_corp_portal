package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Like;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.LikeService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 30.04.2016.
 */
@RestController
@RequestMapping("/likeapi")
public class LikeController {

    private LikeService service;

    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/like/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Like getLikeById(@PathVariable("id") int id)
    {
        Like like = null;
        try {
            like = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return like;
    }

    @RequestMapping(value = "/likes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Like> getAllLike()
    {
        List<Like> list = null;
        try {
            list = service.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Like createLike(@RequestBody Like like)
    {
        try {
            like = service.add(like);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return like;
    }

    @RequestMapping(value = "/likes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public List<Like> createLikes(@RequestBody List<Like> likes)
    {
        try {
            likes = service.add(likes);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return likes;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//


    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/like/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteLikeById(@PathVariable("id")int id)
    {
        try {
            service.delete(id);
        } catch (BadDeleteEntityException e) {
            throw new BadExceptionRest(e.toString());
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        }
    }

    //---------------------END DELETE METHOD-------------------------//
}
