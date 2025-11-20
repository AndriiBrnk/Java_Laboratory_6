package models;

import utils.DateUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Person {
    Logger log = Logger.getLogger(Person.class.getName());
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    static int calcAge(String birthDateStr) {
        if (!DateUtils.isValidDate(birthDateStr)) {
            log.warning("Спроба обчислити вік з невалідною датою: " + birthDateStr);
            throw new DateTimeException("Невірно вказана дата народження: " + birthDateStr);
        }

        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, FORMATTER);
            LocalDate currentDate = LocalDate.now();
            int years = Period.between(birthDate, currentDate).getYears();
            log.fine("Обчислено вік: " + years + " років (дата народження: " + birthDateStr + ")");
            return years;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Помилка під час обчислення віку з дати: " + birthDateStr, e);
            throw new DateTimeException("Не вдалося обчислити вік через некоректну дату.");
        }
    }

    String getFullName();
}