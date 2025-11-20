package repository;

import models.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.StudentRepository;

public class StudentRepositoryTest {

    @Test
    public void testFindByGradeRange() {
        StudentRepository repo = new StudentRepository();
        repo.add(new Student("Андрій", "Берник", "26.01.2006", 307, "01.01.1970"));
        repo.add(new Student("Ульяна", "Голбан", "17.02.2006", 311, "01.01.1970"));

        int ID = 307;
        var result = repo.findByID(ID);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(ID, result.get(0).getStudentID());
    }
}