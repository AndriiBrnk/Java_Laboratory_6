package models;

import enums.Department;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor extends BasePerson {
    private static final Logger log = Logger.getLogger(Professor.class.getName());

    private Department department;

    public Professor(String firstName, String lastName, String birthDate, Department department) {
        super(firstName, lastName, birthDate);
        this.setDepartment(department);
        log.info("Створено професора: " + getFullName() + " (" + department + ")");
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department == null) {
            log.severe("Спроба встановити null як Department у Professor");
            throw new IllegalArgumentException("Кафедра не може бути null.");
        }
        this.department = department;
        log.fine("Оновлено кафедру професора: " + getFullName() + " -> " + department);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return department == professor.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "department=" + department +
                "} " + super.toString();
    }
}