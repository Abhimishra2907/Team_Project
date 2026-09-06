package com.example.teamtask.service;

import com.example.teamtask.entity.Team;
import com.example.teamtask.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public Team create(Team model) {
        return repository.save(model);
    }

    public List<Team> getAll() {
        return repository.findAll();
    }

    public Team getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));
    }

    public Team update(Long id, Team model) {
        Team existing = getById(id);
        existing.setTeamName(model.getTeamName());
        existing.setDescription(model.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
