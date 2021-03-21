package ru.springbootstrap.dao.abstraction.exercise;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springbootstrap.model.Exercise;

import java.util.List;

@Repository
public interface ExerciseDaoCrud extends CrudRepository<Exercise, Long> {
    Exercise findById(long id);
    List<Exercise> findAll();
    List<Exercise> findByFirstNumIsBetween(int i1, int i2);
    void deleteAllById(Long id);

}
