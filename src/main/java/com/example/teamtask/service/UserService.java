package com.example.teamtask.service;

import com.example.teamtask.entity.User;
import com.example.teamtask.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User model) {
        return repository.save(model);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User update(Long id, User model) {
        User existing = getById(id);
        existing.setName(model.getName());
        existing.setEmail(model.getEmail());
        existing.setPassword(model.getPassword());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
