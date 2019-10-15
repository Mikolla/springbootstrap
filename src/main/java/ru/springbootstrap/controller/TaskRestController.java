package ru.springbootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;
import ru.springbootstrap.service.abstraction.role.RoleService;
import ru.springbootstrap.service.abstraction.user.UserService;

import java.util.List;

@RestController
public class TaskRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "rest/usertasks/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
           List<Task> tasks = userService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping(value = "rest/usertasks/addtask")
    public ResponseEntity addTaskByUserId(@RequestParam Long userId,
                                      @RequestParam String taskName) {
        Task task = new Task(taskName);
        userService.addUserTask(userId, task);
        taskService.saveTask(task);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "rest/usertasks/del/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delTasksById(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
