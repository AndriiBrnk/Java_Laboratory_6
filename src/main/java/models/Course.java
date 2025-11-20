package models;

import enums.Seasons;
import exceptions.InvalidCourseCredits;
import exceptions.InvalidCourseTitle;
import utils.CourseUtil;

import java.util.Objects;
import java.util.logging.Logger;

public class Course {
    private static final Logger log = Logger.getLogger(Course.class.getName());

    private String title;
    private int credits;
    private Seasons semester;

    public Course(String title, int credits, Seasons semester) {
        log.info("Створення курсу: " + title + " (" + semester + ")");
        this.setTitle(title);
        this.setCredits(credits);
        this.setSemester(semester);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!CourseUtil.isValidTitle(title)) {
            log.warning("Невалідна назва курсу: " + title);
            throw new InvalidCourseTitle("Назва курсу не повинна бути порожньою або некоректною.");
        }
        log.fine("Задано назву курсу: " + title);
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (!CourseUtil.isValidCredits(credits)) {
            log.warning("Невалідна кількість кредитів: " + credits);
            throw new InvalidCourseCredits(
                    "Кількість кредитів має бути в межах від 1 до 20. Вказано: " + credits
            );
        }
        log.fine("Задано кредити курсу: " + credits);
        this.credits = credits;
    }

    public Seasons getSemester() {
        return semester;
    }

    public void setSemester(Seasons semester) {
        log.fine("Задано семестр курсу: " + semester);
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits
                && Objects.equals(title, course.title)
                && semester == course.semester;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, credits, semester);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", credits=" + credits +
                ", semester=" + semester +
                '}';
    }
}