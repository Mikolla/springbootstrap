package ru.springbootstrap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;

import javax.persistence.PostPersist;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaskRun {

  /*  private TaskService taskService;

    @Autowired TaskRun(TaskService taskService) {
        this.taskService = taskService;
    }*/

    @Autowired
    private TaskService taskService;

    @PostPersist
    public void taskDo(Task task) {

    new Thread(new Runnable() {
        @Autowired
        private TaskService taskService;
        public void run() {

                try {
                    Thread.sleep(5000);
                    synchronized (task) {
                        task.setDone(true);
                    }
                    Thread.sleep(1);
                    taskService.flush();
                } catch (InterruptedException e) {
                }
        }


    }).start();

    }
}
