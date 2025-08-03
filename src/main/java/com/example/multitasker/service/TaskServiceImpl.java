package com.example.multitasker.service;

import com.example.multitasker.exception.TaskNotFoundException;
import com.example.multitasker.model.Task;
import com.example.multitasker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepo;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    @Override
    public Task createTask(Task task) {

        Task newTask = taskRepo.save(task);

        return newTask;
    }

    @Override
    public Optional<Task> getTaskById(Long id) throws TaskNotFoundException {

        Optional<Task> task = taskRepo.findById(id);

        if(task.isPresent()){
            return task;
        }

        throw new TaskNotFoundException(" Task with id " + id + " Not Found !! ");

    }

    @Override
    public List<Task> getAllTasks() {

        List<Task> taskList = taskRepo.findAll();

        return taskList;
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) throws TaskNotFoundException {

        Optional<Task> task = getTaskById(id);

        Task newTask = task.get();

        newTask.setUser(updatedTask.getUser());
        newTask.setDescription(updatedTask.getDescription());
        newTask.setTitle(updatedTask.getTitle());
        newTask.setDueDate(updatedTask.getDueDate());

        return taskRepo.save(newTask);

    }

    @Override
    public void deleteTask(Long id) throws TaskNotFoundException {

        Optional<Task> task = getTaskById(id);

        if(task.isPresent()){
            taskRepo.deleteById(id);
        }

    }

}
