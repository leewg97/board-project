package com.example.board.service;

import com.example.board.dto.CommentDto;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentDto> searchArticleComment(Long articleId) {
        return List.of();
    }

    public void saveArticleComment(CommentDto dto) {
    }

}