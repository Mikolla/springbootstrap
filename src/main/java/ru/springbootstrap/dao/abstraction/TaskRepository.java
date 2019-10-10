package ru.springbootstrap.dao.abstraction;

import org.springframework.transaction.annotation.Transactional;
import ru.springbootstrap.model.Task;

import java.util.List;

@Transactional
public interface TaskRepository extends CommonGenericRepository<Task> {
    @Override
    Task getOne(Long aLong);

    @Override
    Task findOne(Long aLong);

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> List<S> save(Iterable<S> iterable);

    @Override
    <S extends Task> S save(S s);
}
