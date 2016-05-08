package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.Message;
import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.model.exception.badexception.BadAddEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadDeleteEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadGetEntityException;
import by.bsuir.ief.rest.model.exception.badexception.BadUpdateException;
import by.bsuir.ief.rest.model.exception.notfoundexception.AllEntityNotFountException;
import by.bsuir.ief.rest.model.exception.notfoundexception.EntityNotFoundByIdException;
import by.bsuir.ief.rest.model.service.MessageService;
import by.bsuir.ief.rest.util.exceptionrest.BadExceptionRest;
import by.bsuir.ief.rest.util.exceptionrest.EntityNotFoundExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andrey on 30.04.2016.
 */
@RestController
@RequestMapping("/messageapi")
public class MessageController {

    @Autowired
    private MessageService service;


    //----------------------BEGIN GET METHOD-------------------------//

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Message getMessageById(@PathVariable("id") int id)
    {
        Message message = null;
        try {
            message = service.read(id);
        } catch (EntityNotFoundByIdException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return message;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getAllMessage()
    {
        List<Message> list = null;
        try {
            list = service.read();
        } catch (AllEntityNotFountException e) {
            throw new EntityNotFoundExceptionRest(e.toString());
        } catch (BadGetEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return list;
    }

    @RequestMapping(value = "/messageunreaded/{iduser}", method = RequestMethod.GET)
    public List<ShowUnreadedMessage> getUnreadedMessageByIdUser(@PathVariable("iduser")int idUser)
    {
        List<ShowUnreadedMessage> messages = null;
        try {
            messages = service.readUnreaded(idUser);
        } catch (Exception e) {
            throw new BadExceptionRest(e.toString());
        }
        return messages;
    }

    @RequestMapping(value = "/messageonesender/{idSenser}/{idReciver}", method = RequestMethod.GET)
    public List<ShowUnreadedMessage> readMessagesByIdSender(@PathVariable("idSenser")int idSenser,
                                                            @PathVariable("idReciver")int idReciver){
        List<ShowUnreadedMessage> messages = null;
        try {
            messages = service.readMessagesByIdSender(idReciver,idSenser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadExceptionRest(e.getMessage());
        }
        return messages;
    }

    //---------------------END GET METHOD----------------------------//
    // *********************************************************************
    //----------------------BEGIN POST METHOD------------------------//

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Message createMessage(@RequestBody Message message)
    {
        try {
            message = service.add(message);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return message;
    }

    @RequestMapping(value = "/send/{idReciver}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Message sendMessage(@RequestBody Message message, @PathVariable("idReciver") int idReciver)
    {
        try {
            message = service.sendMessageToReciverId(message,idReciver);
        } catch (BadAddEntityException e) {
            throw new BadExceptionRest(e.toString());
        }
        return message;
    }

    //---------------------END POST METHOD---------------------------//
    //*********************************************************************
    //---------------------BEGIN PUT METHODS-------------------------//

    @RequestMapping(value = "/message", method = RequestMethod.PUT)
    public Message putMessage(@RequestBody Message message)
    {
        try {
            message = service.update(message);
        } catch (BadUpdateException e) {
            throw new BadExceptionRest(e.toString());
        }
        return message;
    }

    //---------------------END PUT METHOD----------------------------//
    //*********************************************************************
    //--------------------BEGIN DELETE METHODS-----------------------//

    @RequestMapping(value = "/message/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessageById(@PathVariable("id")int id)
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
