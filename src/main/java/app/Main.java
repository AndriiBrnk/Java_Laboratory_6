package app;

import enums.Department;
import models.Professor;
import models.Student;
import repositories.ProfessorRepository;
import repositories.StudentRepository;

public class Main {
    public static void main(String[] args) {

        ProfessorRepository profRepo = new ProfessorRepository();
        StudentRepository studentRepo = new StudentRepository();

        Professor p1 = new Professor("Oleh", "Sydorenko", "12.05.1980", Department.MATH);
        Professor p2 = new Professor("Anna", "Petrenko", "20.07.1975", Department.PHYSICS);

        Student s1 = new Student("Ivan", "Koval", "15.03.2002", 301, "01.09.2000");
        Student s2 = new Student("Olena", "Bondar", "11.11.2003", 307, "01.09.1995");
        Student s3 = new Student("Taras", "Lysenko", "22.02.2001", 311, "01.09.2023");

        profRepo.add(p1);
        profRepo.add(p2);

        studentRepo.add(s1);
        studentRepo.add(s2);
        studentRepo.add(s3);

        System.out.println("Professors from MATH:");
        profRepo.findByDepartment(Department.MATH).forEach(System.out::println);

        System.out.println("\nStudents with ID 311");
        int ID = 311;
        studentRepo.findByID(ID).forEach(System.out::println);

    }
}