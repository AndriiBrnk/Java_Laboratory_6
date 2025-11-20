package exceptions;

public class InvalidExamPoints extends RuntimeException {
    public InvalidExamPoints(String message) {
        super(message);
    }
}
