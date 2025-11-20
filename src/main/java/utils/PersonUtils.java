package utils;

public abstract class PersonUtils {
    public static boolean isValidName(String name) {
        return name.matches("^[A-ZА-ЯІЇЄ][a-zа-яіїє']{1,30}$");
    }
}
