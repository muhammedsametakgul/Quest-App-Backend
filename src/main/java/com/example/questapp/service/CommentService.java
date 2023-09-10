package com.example.questapp.service;


import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repository.CommentRepository;
import com.example.questapp.repository.PostRepository;
import com.example.questapp.repository.UserRepository;
import com.example.questapp.requests.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private PostService postService;
    private UserService userService;

    @Autowired
    public CommentService(CommentRepository commentRepository,PostService postService,UserService userService) {
        this.commentRepository = commentRepository;
        this.postService=postService;
        this.userService=userService;
    }



    public List<Comment> getAllCommentByPostId(Long id){
        return commentRepository.findByPostId(id);
    }

    public Comment saveOneComment(CommentRequest commentRequest){
        Post post=postService.getOnePost(commentRequest.getPostid());
        User user = userService.getOneUser(commentRequest.getUserid());
        if(post != null){
            Comment comment = new Comment();
            comment.setId(commentRequest.getId());
            comment.setPost(post);
            comment.setUser(user);
            comment.setText(commentRequest.getText());
            return  commentRepository.save(comment);
        }else{
            return  null;
        }
    }

}
