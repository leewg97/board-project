package com.example.board.repository;

import com.example.board.config.JpaConfig;
import com.example.board.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired CommentRepository commentRepository
    ) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    @DisplayName("Select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(150);

    }

    @DisplayName("Insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();

        // When
        Article saveArticle = articleRepository.save(Article.of("new title", "new content", "#new hashtag"));

        // Then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("Update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);

        // When
        Article saveArticle = articleRepository.saveAndFlush(article);

        // Then
        assertThat(saveArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);

    }

    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticle = articleRepository.count();
        long previousComment = commentRepository.count();
        int deletedCommentsSize = article.getComments().size();

        // When
        articleRepository.delete(article);

        // Then
        assertThat(articleRepository.count()).isEqualTo(previousArticle - 1);
        assertThat(commentRepository.count()).isEqualTo(previousComment - deletedCommentsSize);

    }

}