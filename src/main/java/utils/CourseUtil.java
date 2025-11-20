package utils;

public class CourseUtil {
    public static boolean isValidTitle(String title) {
        return title != null && !title.isEmpty();
    }

    public static boolean isValidCredits(int value) {
        return value > 5 && value < 20;
    }
}
