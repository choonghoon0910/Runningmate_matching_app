package com.example.runapp.controller;

import com.example.runapp.entity.Comment;
import com.example.runapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Integer id, @RequestBody Comment updatedComment) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) {
            comment.setPostId(updatedComment.getPostId());
            comment.setAuthorId(updatedComment.getAuthorId());
            comment.setContent(updatedComment.getContent());
            comment.setCreatedAt(updatedComment.getCreatedAt());
            return commentRepository.save(comment);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentRepository.deleteById(id);
    }
}
