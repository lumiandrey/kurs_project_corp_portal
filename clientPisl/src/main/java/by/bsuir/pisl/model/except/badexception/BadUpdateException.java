package by.bsuir.pisl.model.except.badexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class BadUpdateException extends BadEntityException {

    public BadUpdateException(String nameClassEntity, Exception ex) {
        super("Error update to base. Concrete: "+ex.getMessage());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
