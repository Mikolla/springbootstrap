package ru.springbootstrap.model;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")
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
}
