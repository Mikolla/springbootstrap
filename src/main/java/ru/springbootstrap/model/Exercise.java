package ru.springbootstrap.model;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")
public class Exercise {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_num", nullable = false)
    private Integer firstNum;

    @Column(name = "Second_num", nullable = false)
    private Integer secondNum;

    @Column(name = "Action", nullable = false)
    private Character action;

    @Column(name = "Processing_time", nullable = true)
    private Long processingTime;

    @Basic
    @Column(name = "is_done", nullable = true)
    private Boolean isDone = false;



    public Exercise() {
    }

    public Exercise(Integer firstNum, Integer secondNum, Character action) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Integer firstNum) {
        this.firstNum = firstNum;
    }

    public Integer getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Integer secondNum) {
        this.secondNum = secondNum;
    }

    public Character getAction() {
        return action;
    }

    public void setAction(Character action) {
        this.action = action;
    }

    public Long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Long processingTime) {
        this.processingTime = processingTime;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }


}
