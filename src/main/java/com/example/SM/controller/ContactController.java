package com.example.SM.controller;

import com.example.SM.dto.ContactMessageRequest;
import com.example.SM.entity.ContactMessage;
import com.example.SM.repository.ContactMessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final ContactMessageRepository repository;

    public ContactController(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> submitContact(
            @RequestBody ContactMessageRequest request) {

        ContactMessage message = new ContactMessage();

        message.setName(request.getName());
        message.setEmail(request.getEmail());
        message.setPhone(request.getPhone());
        message.setMessage(request.getMessage());

        repository.save(message);

        return ResponseEntity.ok("Message saved successfully");
    }
}
