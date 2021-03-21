package ru.springbootstrap.service.abstraction;

import ru.springbootstrap.model.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getAll();
    Exercise getById(Long id);
    List<Exercise> getByFirstNumRange(int i1, int i2);
    Exercise save(Exercise e);
    void delExercise(Long id);
}
