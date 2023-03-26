package com.example.board.dto;

import java.time.LocalDateTime;

public record CommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {
    public static CommentDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new CommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}