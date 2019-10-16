package ru.springbootstrap.dao;


import org.springframework.beans.factory.annotation.Autowired;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class TaskListener extends Thread{



    @Autowired
    TaskService taskService;
    public Task task;


    public TaskListener(TaskService taskService, Task task) {
        this.taskService = taskService;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.setDone(true);
        taskService.editTask(task);
        taskService.flush();
    }

}
