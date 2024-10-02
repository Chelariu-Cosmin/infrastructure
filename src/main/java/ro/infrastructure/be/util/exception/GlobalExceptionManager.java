package ro.infrastructure.be.util.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import ro.infrastructure.be.util.MessageManager;

@ControllerAdvice
public class GlobalExceptionManager extends MessageManager {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return getLocalizedMessage("error.invalid.argument", request.getLocale());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception ex, WebRequest request) {
        return getLocalizedMessage("error.general", request.getLocale());
    }

    @ExceptionHandler(value = { AccessDeniedException.class })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return getLocalizedMessage("error.access.denied", request.getLocale());
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        return getLocalizedMessage("error.constraint.violation", request.getLocale());
    }

    @ExceptionHandler(value = { HttpMediaTypeNotSupportedException.class })
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, WebRequest request) {
        return getLocalizedMessage("error.media.type.not.supported", request.getLocale());
    }
}
