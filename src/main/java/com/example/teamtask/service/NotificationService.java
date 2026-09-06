package com.example.teamtask.service;

import com.example.teamtask.entity.Notification;
import com.example.teamtask.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification create(Notification model) {
        return repository.save(model);
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }

    public Notification getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
    }

    public Notification update(Long id, Notification model) {
        Notification existing = getById(id);
        existing.setMessage(model.getMessage());
        existing.setType(model.getType());
        existing.setIsRead(model.getIsRead());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
