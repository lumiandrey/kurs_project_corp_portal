package by.bsuir.pisl.model.except.notfoundexception;

/**
 * Created by andrey on 16.04.2016.
 */
abstract public class EntityNotFoundException extends Exception {

    String message;
    public EntityNotFoundException(String _message) {
        message = _message;
    }

    protected EntityNotFoundException() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
