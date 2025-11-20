package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void validDateShouldPass() {
        assertTrue(DateUtils.isValidDate("10.10.2020"));
    }

    @Test
    void invalidDateShouldFail() {
        assertFalse(DateUtils.isValidDate("32.10.2020"));
        assertFalse(DateUtils.isValidDate("abcd"));
    }
}
