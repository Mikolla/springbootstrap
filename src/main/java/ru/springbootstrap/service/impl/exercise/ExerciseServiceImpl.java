package ru.springbootstrap.service.impl.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springbootstrap.dao.abstraction.exercise.ExerciseDao;
import ru.springbootstrap.dao.abstraction.exercise.ExerciseDaoCrud;
import ru.springbootstrap.model.Exercise;
import ru.springbootstrap.service.abstraction.ExerciseService;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    ExerciseDao exerciseDao;
    @Autowired
    ExerciseDaoCrud exerciseDaoCrud;


    @Override
    public List<Exercise> getAll() {
        return exerciseDaoCrud.findAll();
    }

    @Override
    public Exercise getById(Long id) {
        return exerciseDao.getExerciseById(id);
    }

    @Override
    public List<Exercise> getByFirstNumRange(int i1, int i2) {
        return exerciseDaoCrud.findByFirstNumIsBetween(i2, i2);
    }

    @Override
    public Exercise save(Exercise e) {
        return exerciseDao.saveExercise(e);
    }

    @Override
    public void delExercise(Long id) {
        exerciseDao.deleteExercise(id);
    }
}
