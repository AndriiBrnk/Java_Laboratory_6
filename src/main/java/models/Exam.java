package models;

import enums.ExamType;
import exceptions.InvalidExamPoints;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exam {
    private static final Logger log = Logger.getLogger(Exam.class.getName());

    private Course course;
    private ExamType type;
    private LocalDate date;
    private int maxPoints;

    public Exam(Course course, ExamType type, String date, int maxPoints) {
        this.setCourse(course);
        this.setType(type);
        this.setDate(date);
        this.setMaxPoints(maxPoints);
        log.info("Створено екзамен: " + this);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            log.severe("Передано null як Course при створенні Exam");
            throw new IllegalArgumentException("Курс не може бути null");
        }
        log.fine("Призначено курс: " + course.getTitle());
        this.course = course;
    }

    public ExamType getType() {
        return type;
    }

    public void setType(ExamType type) {
        if (type == null) {
            log.severe("Передано null як ExamType при створенні Exam");
            throw new IllegalArgumentException("Тип іспиту не може бути null");
        }
        log.fine("Призначено тип іспиту: " + type);
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String dateStr) {
        try {
            this.date = LocalDate.parse(dateStr);
            log.fine("Призначено дату іспиту: " + dateStr);
        } catch (DateTimeParseException e) {
            log.log(Level.SEVERE, "Помилка при парсингу дати: " + dateStr, e);
            throw new IllegalArgumentException("Невірний формат дати. Очікується YYYY-MM-DD.");
        }
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        if (maxPoints < 0 || maxPoints > 100) {
            log.warning("Невірне значення балів: " + maxPoints);
            throw new InvalidExamPoints("Кількість балів не повинна бути менше 0 і більше 100.");
        }
        log.fine("Призначено максимальні бали: " + maxPoints);
        this.maxPoints = maxPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return maxPoints == exam.maxPoints &&
                Objects.equals(course, exam.course) &&
                type == exam.type &&
                Objects.equals(date, exam.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, type, date, maxPoints);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "course=" + course +
                ", type=" + type +
                ", date=" + date +
                ", maxPoints=" + maxPoints +
                '}';
    }
}