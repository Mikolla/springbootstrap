package ru.springbootstrap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.springbootstrap.model.Exercise;
import ru.springbootstrap.service.abstraction.ExerciseService;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ExerciseRestController {
    private final ExerciseService exerciseService;

    @Inject
    public ExerciseRestController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(value = "rest/exercise/{exId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Exercise> getTasksByUserId(@PathVariable Long exId) {
        Exercise exercise = exerciseService.getById(exId);
        List<Exercise> list = exerciseService.getAll();
        Exercise e = new Exercise(91, 91, '*');
        exerciseService.save(e);
        long id = e.getId();
        exerciseService.delExercise(id);
        return ResponseEntity.ok(exercise);
    }

    @PostMapping(value = "rest/exercise/del")
    public ResponseEntity delExercise(@RequestParam (value = "exerciseId", required = true) Long exerciseId)
    {
        exerciseService.delExercise(exerciseId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "rest/exercise/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exercises = exerciseService.getAll();
        return ResponseEntity.ok(exercises);
    }

}
