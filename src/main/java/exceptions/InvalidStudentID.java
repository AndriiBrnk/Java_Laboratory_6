package exceptions;

public class InvalidStudentID extends RuntimeException {
    public InvalidStudentID(String message) {
        super(message);
    }
}
