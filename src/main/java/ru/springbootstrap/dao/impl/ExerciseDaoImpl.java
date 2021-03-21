package ru.springbootstrap.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootstrap.dao.abstraction.exercise.ExerciseDao;
import ru.springbootstrap.model.Exercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExerciseDaoImpl implements ExerciseDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public Exercise saveExercise(Exercise exercise) {
        em.persist(exercise);
        return exercise;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public Exercise getExerciseById(long id) {
        return em.find(Exercise.class, id);
    }

    @Override
    public void editExercise(Exercise exercise) {
        em.merge(exercise);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public void deleteExercise(long id) {
        em.remove(em.find(Exercise.class, id));
    }
}
