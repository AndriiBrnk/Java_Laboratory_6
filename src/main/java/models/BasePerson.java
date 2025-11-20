package models;

import exceptions.InvalidDateException;
import exceptions.InvalidPersonName;
import utils.DateUtils;
import utils.PersonUtils;

import java.util.Objects;
import java.util.logging.Logger;

public abstract class BasePerson implements Person {
    private static final Logger log = Logger.getLogger(BasePerson.class.getName());

    private String firstName;
    private String lastName;
    private String birthDate;

    public BasePerson(String firstName, String lastName, String birthDate) {
        log.info("Створення BasePerson: " + firstName + " " + lastName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!PersonUtils.isValidName(firstName)) {
            log.warning("Невалідне ім'я: " + firstName);
            throw new InvalidPersonName("Неправильно введене ім'я.");
        }
        log.fine("Задано ім'я: " + firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!PersonUtils.isValidName(lastName)) {
            log.warning("Невалідне прізвище: " + lastName);
            throw new InvalidPersonName("Неправильно введене прізвище.");
        }
        log.fine("Задано прізвище: " + lastName);
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (!DateUtils.isValidDate(birthDate)) {
            log.warning("Невалідна дата народження: " + birthDate);
            throw new InvalidDateException("Невірно вказана дата.");
        }
        log.fine("Задано дату народження: " + birthDate);
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BasePerson that = (BasePerson) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    @Override
    public String toString() {
        return "BasePerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public String getFullName() {
        return "%s %s".formatted(this.firstName, this.lastName);
    }
}