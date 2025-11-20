package models;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enrollment {
    private static final Logger log = Logger.getLogger(Enrollment.class.getName());

    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        if (student == null || course == null) {
            log.severe("Спроба створити Enrollment з null-значеннями");
            throw new IllegalArgumentException("Студент і курс не можуть бути null");
        }
        log.info("Створення Enrollment: " + student.getFullName() + " -> " + course.getTitle());
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (student == null) {
            log.warning("Спроба призначити null як Student");
            throw new IllegalArgumentException("Студент не може бути null");
        }
        log.fine("Оновлено студента в Enrollment: " + student.getFullName());
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            log.warning("Спроба призначити null як Course");
            throw new IllegalArgumentException("Курс не може бути null");
        }
        log.fine("Оновлено курс в Enrollment: " + course.getTitle());
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}