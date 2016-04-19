package by.bsuir.ief.rest.model.exception.notfoundexception;

/**
 * Created by andrey on 16.04.2016.
 */
abstract public class EntityNotFoundException extends Exception {

    String message;
    public EntityNotFoundException(String _message) {
        message = _message;
    }

    @Override
    public String toString() {
        return message;
    }
}
