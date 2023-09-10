package com.example.questapp.Controller;


import com.example.questapp.entities.Comment;
import com.example.questapp.requests.CommentRequest;
import com.example.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @GetMapping("/{postId}")
    public List<Comment>  getAllCommentsByPostId(@PathVariable Long postId){
        return  commentService.getAllCommentByPostId(postId);
    }


    @PostMapping
    public void saveComment(@RequestBody CommentRequest commentRequest){
        commentService.saveOneComment(commentRequest);

    }








}
