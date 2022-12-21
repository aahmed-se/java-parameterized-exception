
package parameterized.exception;

import org.slf4j.helpers.MessageFormatter;

public abstract class BaseException extends Exception {

    private static final long serialVersionUID = -2343132778619884518L;

    private static String format(String message, Object... os) {
        Throwable throwableCandidate = MessageFormatter.getThrowableCandidate(os);
        Object[] args = os;
        if (throwableCandidate != null) {
            args = MessageFormatter.trimmedCopy(os);
        }
        return MessageFormatter.arrayFormat(message, args, null).getMessage();
    }

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object... os) {
        this(format(message, os), MessageFormatter.getThrowableCandidate(os));
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
