package by.bsuir.pisl.model.except.badexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class BadAddEntityException extends BadEntityException{

    public BadAddEntityException(String nameClassEntity, Exception ex) {
        super("Error insert to base. Concrete: "+ex.getMessage());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
