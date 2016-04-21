package by.bsuir.ief.rest.util.exceptionrest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by andrey on 21.03.2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)  // 404
public class EntityNotFoundExceptionRest extends RuntimeException {
    public EntityNotFoundExceptionRest() {
        super();
    }
    public EntityNotFoundExceptionRest(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFoundExceptionRest(String message) {
        super(message);
    }
    public EntityNotFoundExceptionRest(Throwable cause) {
        super(cause);
    }
}

