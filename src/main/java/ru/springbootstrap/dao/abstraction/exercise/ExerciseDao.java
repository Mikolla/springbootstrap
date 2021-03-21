package ru.springbootstrap.dao.abstraction.exercise;

import ru.springbootstrap.model.Exercise;

public interface ExerciseDao {
    Exercise saveExercise(Exercise exercise);

    Exercise getExerciseById(long id);

    void editExercise(Exercise exercise);

    void deleteExercise(long id);

}
