package ru.springbootstrap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;

import javax.persistence.PostPersist;

@Component
public class TaskRun {

  /*  private TaskService taskService;

    @Autowired TaskRun(TaskService taskService) {
        this.taskService = taskService;
    }*/


    @PostPersist
    public void taskDo(Task task) {

    new Thread(new Runnable() {
        public void run() {

                try {
                    Thread.sleep(5000);
                    task.setDone(true);
                } catch (InterruptedException e) {
                }
        }


    }).start();

    }
}
