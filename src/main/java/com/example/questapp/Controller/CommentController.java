package com.example.questapp.Controller;


import com.example.questapp.entities.Comment;
import com.example.questapp.requests.CommentRequest;
import com.example.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @GetMapping
    public List<Comment>  getAllCommentsByPostId(@RequestParam("postid") Optional<Long> postId){
        return  commentService.getAllCommentByPostId(postId);

        // /comment?postid=1
    }


    @PostMapping
    public void saveComment(@RequestBody CommentRequest commentRequest){
        commentService.saveOneComment(commentRequest);

    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId,@RequestBody CommentRequest commentRequest){
        return  commentService.updateComment(commentId,commentRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
          commentService.deleteComment(commentId);
    }








}
