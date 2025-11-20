package models;

import enums.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void validProfessorShouldBeCreated() {
        Professor p = new Professor("Олег", "Сидоренко", "12.05.1980", Department.MATH);
        assertEquals("Олег Сидоренко", p.getFullName());
        assertEquals(Department.MATH, p.getDepartment());
    }
}