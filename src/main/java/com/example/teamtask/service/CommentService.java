package com.example.teamtask.service;

import com.example.teamtask.entity.Comment;
import com.example.teamtask.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment create(Comment model) {
        return repository.save(model);
    }

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Comment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    public Comment update(Long id, Comment model) {
        Comment existing = getById(id);
        existing.setMessage(model.getMessage());
        existing.setCreatedBy(model.getCreatedBy());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
