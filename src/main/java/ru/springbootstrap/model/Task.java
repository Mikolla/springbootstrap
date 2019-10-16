package ru.springbootstrap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.springbootstrap.dao.TaskDoer;
import ru.springbootstrap.dao.TaskListener;
import ru.springbootstrap.dao.TaskRun;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tasks")
@EntityListeners(TaskRun.class)
public class Task {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Task_name", nullable = false)
    private String taskName;

    @Basic
    @Column(name = "is_done")
    private Boolean isDone = false;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY, targetEntity = User.class)
    @JoinTable(name = "users_tasks",  joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})

    private User user;

    public Task() {
    }

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
