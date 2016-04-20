package by.bsuir.ief.rest.model.exception.badexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class BadGetEntityException extends BadEntityException {
    public BadGetEntityException( String nameClassEntity, Exception ex) {
        super("Error get Entity to base. Entity : " + nameClassEntity + " Declaration error: " + ex.getMessage());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
