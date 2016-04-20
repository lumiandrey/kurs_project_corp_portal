package by.bsuir.ief.rest.model.exception.notfoundexception;

/**
 * Created by andrey on 17.04.2016.
 */
public class EntityNotFoundByIdException extends EntityNotFoundException {
    public EntityNotFoundByIdException(int id, String nameClassEntity) {
        super("Not found "  + nameClassEntity + " by id = " + id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
