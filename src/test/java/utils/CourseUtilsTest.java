package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseUtilsTest {

    @Test
    void validTitleShouldPass() {
        assertTrue(CourseUtil.isValidTitle("Алгоритми"));
    }

    @Test
    void invalidTitleShouldFail() {
        assertFalse(CourseUtil.isValidTitle(""));
    }

    @Test
    void validCreditsShouldPass() {
        assertFalse(CourseUtil.isValidCredits(5));
    }

    @Test
    void invalidCreditsShouldFail() {
        assertFalse(CourseUtil.isValidCredits(25));
    }
}
