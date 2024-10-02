package ro.infrastructure.be.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1644467856346594869L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
