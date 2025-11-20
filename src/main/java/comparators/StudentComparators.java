package comparators;

import models.Student;

import java.util.Comparator;

public class StudentComparators {
    public static final Comparator<Student> BY_FIRST_NAME =
            (s1, s2) -> s1.getFirstName().compareToIgnoreCase(s2.getFirstName());

    public static final Comparator<Student> BY_LAST_NAME =
            (s1, s2) -> s1.getLastName().compareToIgnoreCase(s2.getLastName());

    public static final Comparator<Student> BY_ID =
            Comparator.comparingDouble(Student::getStudentID);
}
