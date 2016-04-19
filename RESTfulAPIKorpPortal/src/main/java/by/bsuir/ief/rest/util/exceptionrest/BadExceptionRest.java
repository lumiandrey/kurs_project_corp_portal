package by.bsuir.ief.rest.util.exceptionrest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason="Very bad server")  // 404
public class BadExceptionRest extends RuntimeException {
    public BadExceptionRest(String messages) {
        super(messages);
    }
}
