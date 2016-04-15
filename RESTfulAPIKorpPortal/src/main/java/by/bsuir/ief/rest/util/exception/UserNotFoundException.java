package by.bsuir.ief.rest.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by andrey on 21.03.2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such User")  // 404
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int Id) {
        super(Id + " not found");
    }
}

