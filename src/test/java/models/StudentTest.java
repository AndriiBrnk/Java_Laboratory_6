package models;

import exceptions.InvalidStudentID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void validStudentShouldBeCreated() {
        Student s = new Student("Іван", "Коваль", "15.03.2004", 101, "01.09.2022");
        assertEquals("Іван Коваль", s.getFullName());
        assertEquals(101, s.getStudentID());
    }

    @Test
    void invalidStudentIdShouldThrow() {
        assertThrows(InvalidStudentID.class,
                () -> new Student("Іван", "Коваль", "15.03.2004", -5, "01.09.2022"));
    }

    @Test
    void invalidEnrollmentDateShouldThrow() {
        assertThrows(Exception.class,
                () -> new Student("Іван", "Коваль", "15.03.2004", 101, "31.02.2022"));
    }
}
