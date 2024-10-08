package ro.infrastructure.be.module.shared.event;

import java.io.Serial;
import java.util.Date;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The AuditEvent class is used to record security audit events and actions. It can be created and sent from any code, and is captured by the
 * AuditEventListener for handling and persistence.
 */
@Async
@Getter
@EqualsAndHashCode(callSuper = false)
public class AuditEvent extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = -3080087405995363006L;

    /** The date of the event. This is auto-populated upon object creation. */
    private final Date date;

    /** The session id. */
    private final String sessionId;

    /** The ip address. */
    private final String ipAddress;

    /** The user agent. */
    private final String userAgent;

    /** The action. */
    private final String action;

    /** The action status. */
    private final String actionStatus;

    /** The message. */
    private final String message;

    /** The extra data. */
    private final String extraData;

    /**
     * Instantiates a new audit event. Using Builder annotation on this method instead of on the class itself, in order to handle the source field
     * which is on the superclass.
     *
     * @param source the source
     * @param sessionId the session id
     * @param ipAddress the ip address
     * @param userAgent the user agent
     * @param action the action
     * @param actionStatus the action status
     * @param message the message
     * @param extraData the extra data
     */
    @Builder
    public AuditEvent(Object source, String sessionId, String ipAddress, String userAgent, String action, String actionStatus,
                      String message, String extraData) {
        super(source);
        this.date = new Date(System.currentTimeMillis());
        this.sessionId = sessionId;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.action = action;
        this.actionStatus = actionStatus;
        this.message = message;
        this.extraData = extraData;
    }
}