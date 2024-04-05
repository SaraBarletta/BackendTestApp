package controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import service.PostService;
import model.Post;

@RestController
public class PostController {

	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	public PostService getPostService() {
		return postService;
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {
	    return postService.findAll();
	}

	@GetMapping("/posts/{id}")
	public Post getPostById(@PathVariable Long id) {
	    return postService.findById(id);
	}
	
	@PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }

}
