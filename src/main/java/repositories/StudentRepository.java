package repositories;

import models.Student;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StudentRepository extends BaseRepository<Student> {

    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public List<Student> findByID(int ID) {
        logger.info("findByGID called");

        return data.stream()
                .filter(s -> s.getStudentID() == ID)
                .collect(Collectors.toList());
    }}