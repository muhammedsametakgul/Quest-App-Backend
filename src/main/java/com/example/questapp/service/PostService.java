package com.example.questapp.service;

import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repository.PostRepository;
import com.example.questapp.requests.PostCreateRequest;
import com.example.questapp.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }


    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }else{
            return  postRepository.findAll();
        }
    }

    public Post getOnePost(Long postId) {
        return  postRepository.findById(postId).orElse(null);
    }

    public Post save(PostCreateRequest postCreateRequest) {
        User user =userService.getOneUser(postCreateRequest.getUser_id());
        if(user==null){
            return  null;
        }
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUser(user);
         return postRepository.save(toSave);
    }

    public void deletePost(Long postId) {
          postRepository.delete(getOnePost(postId));
    }

    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post newPost = post.get();
            newPost.setText(postUpdateRequest.getText());
            newPost.setTitle(postUpdateRequest.getTitle());
            postRepository.save(newPost);
            return newPost;
        }

        return  null;
    }
}
