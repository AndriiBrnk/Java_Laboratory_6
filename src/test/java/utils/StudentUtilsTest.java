package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentUtilsTest {

    @Test
    void validStudentIdShouldPass() {
        assertTrue(StudentUtils.isValidStudentID(123));
    }

    @Test
    void invalidStudentIdShouldFail() {
        assertFalse(StudentUtils.isValidStudentID(-1));
    }

    @Test
    void validEnrollmentDateShouldPass() {
        assertTrue(StudentUtils.isValidEnrollmentDate("01.09.2022"));
    }

    @Test
    void invalidEnrollmentDateShouldFail() {
        assertFalse(StudentUtils.isValidEnrollmentDate("31.02.2022"));
    }
}
