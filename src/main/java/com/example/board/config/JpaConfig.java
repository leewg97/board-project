package com.example.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean   // 사람 이름 정보를 넣기 위한 설정
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("Lee");    // TODO: Spring Security로 인증 구현 시 수정
    }

}
