package ru.springbootstrap.service.abstraction;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.springbootstrap.model.Task;

import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface TaskService {
    void saveTask(Task task);

    Task getTaskById(long id);

    void editTask(Task task);

    void deleteTask(long id);

    List<Task> getAllTasks();

    List<Task> getTasksByUserId(Long id);

    void flush();
}
