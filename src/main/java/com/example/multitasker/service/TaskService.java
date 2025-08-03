package com.example.multitasker.service;

import com.example.multitasker.exception.TaskNotFoundException;
import com.example.multitasker.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    Optional<Task> getTaskById(Long id) throws TaskNotFoundException;

    List<Task> getAllTasks();

    Task updateTask(Long id, Task updatedTask) throws TaskNotFoundException;

    void deleteTask(Long id) throws TaskNotFoundException ;

}
