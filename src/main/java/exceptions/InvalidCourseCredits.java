package exceptions;

public class InvalidCourseCredits extends RuntimeException {
    public InvalidCourseCredits(String message) {
        super(message);
    }
}
