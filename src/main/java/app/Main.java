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


        // -----------------------------
        // Порівняння stream vs parallelStream
        // -----------------------------

        String targetLastName = "Bondar";

        long start1 = System.nanoTime();
        long count1 = studentRepo.getAll()
                .stream()
                .filter(s -> s.getLastName().equals(targetLastName))
                .count();
        long timeStream = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        long count2 = studentRepo.getAll()
                .parallelStream()
                .filter(s -> s.getLastName().equals(targetLastName))
                .count();
        long timeParallel = System.nanoTime() - start2;

        System.out.println("Stream: " + count1 + ", time: " + timeStream);
        System.out.println("Parallel stream: " + count2 + ", time: " + timeParallel);

        if (timeStream < timeParallel)
            System.out.println("Stream is faster");
        else
            System.out.println("Parallel stream is faster");
    }
}
