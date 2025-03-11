package com.example.runapp.controller;

import com.example.runapp.entity.Post;
import com.example.runapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post updatedPost) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setAuthorId(updatedPost.getAuthorId());
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            post.setCreatedAt(updatedPost.getCreatedAt());
            return postRepository.save(post);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        postRepository.deleteById(id);
    }
}
