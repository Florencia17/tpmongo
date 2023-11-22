package com.mongo.tpmongo.springbootmongo.controllers;

import com.mongo.tpmongo.springbootmongo.api.PostService;
import com.mongo.tpmongo.springbootmongo.dto.AuthorPostCount;
import com.mongo.tpmongo.springbootmongo.model.Page;
import com.mongo.tpmongo.springbootmongo.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/byauthor")
    public List<AuthorPostCount> getPagesByAuthor() {
        return this.postService.countPostsByAuthor();
    }

    @GetMapping("/latest")
    public List<Post> getLatest4Posts() {
        return this.postService.findLatestPosts();
    }

    @GetMapping("/author/{nombreautor}")
    public List<Post> getPostsByAuthor(@PathVariable String nombreautor) {
        return this.postService.findPostsByAuthor(nombreautor);
    }

    @GetMapping("/search/{text}")
    public List<Post> searchPosts(@PathVariable String text) {
        return this.postService.findPostsByText(text);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception exception) {
        exception.printStackTrace();
    }
}
