package ru.springbootstrap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;




import javax.persistence.PostPersist;


public class TaskDoer {

    private TaskRun taskRun;

    @Autowired TaskDoer(TaskRun taskRun) {
        this.taskRun = taskRun;
    }


    public void userPostPersist(Task task) {
       taskRun.taskDo(task);
    }
}
