package ru.springbootstrap.dao.impl.task;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.springbootstrap.dao.abstraction.task.TaskDao;
import ru.springbootstrap.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public void saveTask(Task task) {
        em.persist(task);
    }

    @Override
    public Task getTaskById(long id) {
        return em.find(Task.class, id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public void editTask(Task task) {
        em.merge(task);
    }

    @Override
    public void deleteTask(long id) {
        em.remove(em.find(Task.class, id));
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(Long id) {
        return null;
    }

    @Override
    public void flush() {
        em.flush();
    }
}
