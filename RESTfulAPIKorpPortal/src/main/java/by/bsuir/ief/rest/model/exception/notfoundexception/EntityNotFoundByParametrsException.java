package by.bsuir.ief.rest.model.exception.notfoundexception;

/**
 * Created by andrey on 21.04.2016.
 */
public class EntityNotFoundByParametrsException extends EntityNotFoundException {

    public EntityNotFoundByParametrsException(String _message, String ...args) {
        String message = "";
        for(String o: args)
            message += o;
        super.setMessage(message);
    }
}
