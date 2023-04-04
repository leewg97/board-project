package com.example.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외")
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mockMvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNoting_whenRequestingArticle_thenReturnArticlesJsonResponse() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNoting_whenRequestingArticle_thenReturnArticleJsonResponse() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNoting_whenRequestingCommentsFromArticle_thenReturnCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/articles/1/comments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNoting_whenRequestingComments_thenReturnCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/articles/1/comments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNoting_whenRequestingComment_thenReturnCommentJsonResponse() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/comments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 회원 관련 API 는 일체 제공하지 않는다.")
    @Test
    void givenNothing_whenRequestingUserAccounts_thenThrowsException() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/userAccounts")).andExpect(status().isNotFound());
        mockMvc.perform(post("/api/userAccounts")).andExpect(status().isNotFound());
        mockMvc.perform(put("/api/userAccounts")).andExpect(status().isNotFound());
        mockMvc.perform(patch("/api/userAccounts")).andExpect(status().isNotFound());
        mockMvc.perform(delete("/api/userAccounts")).andExpect(status().isNotFound());
        mockMvc.perform(head("/api/userAccounts")).andExpect(status().isNotFound());
    }


}
