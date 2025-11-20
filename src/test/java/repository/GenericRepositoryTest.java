package repository;

import models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenericRepositoryTest {

    private GenericRepository<Student> repo;

    @BeforeEach
    void setup() {
        repo = new GenericRepository<>(Student::getStudentID);
    }

    @Test
    void addAndFindStudent() {
        Student s = new Student("Іван", "Коваль", "15.03.2004", 101, "01.09.2022");
        repo.add(s);

        Optional<Student> found = repo.findByIdentity(101);
        assertTrue(found.isPresent());
        assertEquals("Іван", found.get().getFirstName());
    }

    @Test
    void removeStudent() {
        Student s = new Student("Іван", "Коваль", "15.03.2004", 101, "01.09.2022");
        repo.add(s);
        repo.remove(s);
        assertTrue(repo.getAll().isEmpty());
    }

    @Test
    void duplicatesShouldNotBeAdded() {
        Student s1 = new Student("Іван", "Коваль", "15.03.2004", 101, "01.09.2022");
        Student s2 = new Student("Іван", "Коваль", "15.03.2004", 101, "01.09.2022");

        repo.add(s1);
        repo.add(s2);

        List<Student> all = repo.getAll();
        assertEquals(1, all.size());
    }
}