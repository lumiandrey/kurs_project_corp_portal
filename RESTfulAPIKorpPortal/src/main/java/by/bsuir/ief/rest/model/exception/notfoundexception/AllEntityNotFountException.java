package by.bsuir.ief.rest.model.exception.notfoundexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class AllEntityNotFountException extends EntityNotFoundException {
    public AllEntityNotFountException(String nameClassEntity) {
        super("Not found All Entity "  + nameClassEntity );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
