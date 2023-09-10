package com.example.questapp.requests;

import lombok.Data;

@Data
public class CommentRequest {
    Long id;
    Long userid;
    Long postid;
    String text;
}
