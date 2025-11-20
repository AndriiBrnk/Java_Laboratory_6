package repositories;

import models.Professor;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProfessorRepository extends BaseRepository<Professor> {

    private static final Logger logger = Logger.getLogger(ProfessorRepository.class.getName());

    public List<Professor> findByDepartment(Enum<?> department) {
        logger.info("findByDepartment called");

        return data.stream()
                .filter(p -> p.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public List<String> getFullNames() {
        logger.info("getFullNames called");

        return data.stream()
                .map(Professor::getFullName)
                .collect(Collectors.toList());
    }
}