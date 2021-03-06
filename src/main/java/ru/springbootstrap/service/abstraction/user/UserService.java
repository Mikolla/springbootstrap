package ru.springbootstrap.service.abstraction.user;

import ru.springbootstrap.model.Task;
import ru.springbootstrap.model.User;

import java.util.List;

public interface UserService {
     void saveUser(User user);

     User getUserById(long id);

     void editUser(User user);

     User getUserByLogin(String login);

     List<User> getAllUsers();

     void deleteUser(long id);

     List<Task> getTasksByUserId(long id);

     void addUserTask(long id, Task task);
}
