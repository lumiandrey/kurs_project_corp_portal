package by.bsuir.pisl.model.except.badexception;

/**
 * Created by andrey on 17.04.2016.
 */
abstract public class BadEntityException extends Exception {
    String message;
    public BadEntityException(String _message) {
        message = _message;
    }

    @Override
    public String toString() {
        return message;
    }
}
