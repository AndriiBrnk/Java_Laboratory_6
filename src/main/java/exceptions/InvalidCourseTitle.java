package exceptions;

public class InvalidCourseTitle extends RuntimeException {
  public InvalidCourseTitle(String message) {
    super(message);
  }
}
