package com.example.teamtask.controller;

import com.example.teamtask.entity.Team;
import com.example.teamtask.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @PostMapping
    public Team create(@RequestBody Team model) {
        return service.create(model);
    }

    @GetMapping
    public List<Team> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Long id, @RequestBody Team model) {
        return service.update(id, model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Team deleted successfully";
    }
}
