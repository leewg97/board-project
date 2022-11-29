package com.example.board.domain;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private Article article;
    private String content;

    private LocalDateTime createdAt;
    private String cratedBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;


}