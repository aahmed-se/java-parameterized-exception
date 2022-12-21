package parameterized.exception;


public class SampleException extends BaseException {

    protected SampleException() {
        super();
    }

    protected SampleException(String message) {
        super(message);
    }

    protected SampleException(String message, Object... os) {
        super(message, os);
    }

    protected SampleException(Throwable cause) {
        super(cause);
    }

    protected SampleException(String message, Throwable cause) {
        super(message, cause);
    }
}