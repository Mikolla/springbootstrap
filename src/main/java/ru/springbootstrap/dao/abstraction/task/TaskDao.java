package ru.springbootstrap.dao.abstraction.task;

import ru.springbootstrap.model.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Task task);

    Task getTaskById(long id);

    void editTask(Task task);

    void deleteTask(long id);

    List<Task> getAllTasks();

    List<Task> getTasksByUserId(Long id);

    void flush();
}
