package fortylines.io.fortylines_hr.exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
