package ru.springbootstrap.service.impl.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootstrap.dao.abstraction.task.TaskDao;
import ru.springbootstrap.model.Task;
import ru.springbootstrap.service.abstraction.TaskService;


import java.util.List;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public void saveTask(Task task) {
        taskDao.saveTask(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void editTask(Task task) {
        taskDao.editTask(task);
    }

    @Override
    public void deleteTask(long id) {
        taskDao.deleteTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public List<Task> getTasksByUserId(Long id) {
        return taskDao.getTasksByUserId(id);
    }
}
