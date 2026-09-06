package com.example.teamtask.service;

import com.example.teamtask.entity.Task;
import com.example.teamtask.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task model) {
        return repository.save(model);
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public Task update(Long id, Task model) {
        Task existing = getById(id);
        existing.setTitle(model.getTitle());
        existing.setDescription(model.getDescription());
        existing.setStatus(model.getStatus());
        existing.setPriority(model.getPriority());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
