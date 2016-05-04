package by.bsuir.pisl.model.except.badexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class BadDeleteEntityException extends BadEntityException {
    public BadDeleteEntityException(String message, String nameClassEntity, Exception ex) {
        super("Error delete in base. " + message + " Concrete: " + ex.getMessage());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
