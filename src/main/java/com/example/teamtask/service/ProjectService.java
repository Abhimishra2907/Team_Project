package com.example.teamtask.service;

import com.example.teamtask.entity.Project;
import com.example.teamtask.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(Project model) {
        return repository.save(model);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public Project update(Long id, Project model) {
        Project existing = getById(id);
        existing.setProjectName(model.getProjectName());
        existing.setDescription(model.getDescription());
        existing.setStatus(model.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
