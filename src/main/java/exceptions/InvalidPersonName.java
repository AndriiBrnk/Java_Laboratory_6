package exceptions;

public class InvalidPersonName extends RuntimeException {
    public InvalidPersonName(String message) {
        super(message);
    }
}
