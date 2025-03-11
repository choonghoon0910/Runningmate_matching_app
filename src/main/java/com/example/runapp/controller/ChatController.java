package com.example.runapp.controller;

import com.example.runapp.entity.Chat;
import com.example.runapp.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chat getChatById(@PathVariable Integer id) {
        return chatRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable Integer id, @RequestBody Chat updatedChat) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if (chat != null) {
            chat.setMatchId(updatedChat.getMatchId());
            chat.setSenderId(updatedChat.getSenderId());
            chat.setMessage(updatedChat.getMessage());
            chat.setSentAt(updatedChat.getSentAt());
            return chatRepository.save(chat);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable Integer id) {
        chatRepository.deleteById(id);
    }
}
