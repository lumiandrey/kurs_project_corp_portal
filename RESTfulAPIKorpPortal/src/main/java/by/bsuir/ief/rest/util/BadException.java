package by.bsuir.ief.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Very bad")  // 404
public class BadException extends RuntimeException {
    public BadException() {
        super("Smth is bad");
    }
}
