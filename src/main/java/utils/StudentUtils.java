package utils;

public class StudentUtils extends PersonUtils {
    public static boolean isValidStudentID(int value) {
        return value > 100 && value < 600;
    }

    public static boolean isValidEnrollmentDate(String date)
    {
        return DateUtils.isValidDate(date);
    }
}
