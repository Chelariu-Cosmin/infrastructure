package ro.infrastructure.be.util;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@NoArgsConstructor
public abstract class MessageManager {

    @Autowired
    private MessageSource messageSource;

    public String getLocalizedMessage(String message, Locale locale) {
        return messageSource.getMessage(message, null, locale);
    }

    public String getMessage(String message, Object... args) {
        return messageSource.getMessage(message, args, Locale.getDefault());
    }

    public String getSimpleMessage(String message) {
        return getLocalizedMessage(message, Locale.getDefault());
    }
}
