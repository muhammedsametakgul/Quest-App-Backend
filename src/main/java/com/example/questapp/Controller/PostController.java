package com.example.questapp.Controller;

import com.example.questapp.entities.Post;
import com.example.questapp.requests.PostCreateRequest;
import com.example.questapp.requests.PostUpdateRequest;
import com.example.questapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return  postService.getAllPosts(userId);
        //http://localhost:8080/post?user_id=*     * represent the value we gave in postman
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
         postService.deletePost(postId);
    }


    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId){
        return  postService.getOnePost(postId);
    }


    @PostMapping
    public Post savePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.save(newPostRequest);
    }


    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updatePost(postId,postUpdateRequest);
    }
}

