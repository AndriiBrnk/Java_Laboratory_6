package models;

import exceptions.InvalidStudentID;
import utils.StudentUtils;

import java.time.DateTimeException;
import java.util.Objects;
import java.util.logging.Logger;

public class Student extends BasePerson implements Comparable<Student> {
    private static final Logger log = Logger.getLogger(Student.class.getName());

    private int studentID;
    private String enrollmentDate;

    public Student(String firstName, String lastName, String birthDate, int studentID, String enrollmentDate) {
        super(firstName, lastName, birthDate);
        this.setStudentID(studentID);
        this.setEnrollmentDate(enrollmentDate);
        log.info("Створено студента: " + getFullName() + " (ID: " + studentID + ", дата зарахування: " + enrollmentDate + ")");
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        if (!StudentUtils.isValidStudentID(studentID)) {
            log.severe("Невірний studentID: " + studentID);
            throw new InvalidStudentID("ID студента не повинно бути від'ємним.");
        }
        this.studentID = studentID;
        log.fine("Встановлено studentID: " + studentID);
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        if (!StudentUtils.isValidEnrollmentDate(enrollmentDate)) {
            log.warning("Невірна дата зарахування: " + enrollmentDate);
            throw new DateTimeException("Невірно вказана дата зарахування.");
        }
        this.enrollmentDate = enrollmentDate;
        log.fine("Встановлено enrollmentDate: " + enrollmentDate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentID == student.studentID &&
                Objects.equals(enrollmentDate, student.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentID, enrollmentDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                "} " + super.toString();
    }

    //5
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentID, other.studentID);
    }
}