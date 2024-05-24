package com.example.chatex;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String DEVELOP_FRONT_ADDRESS = "http://localhost:3000";

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정을 적용
                .allowedOrigins(DEVELOP_FRONT_ADDRESS) // 개발 환경의 프론트엔드 주소에서 오는 요청을 허용
                .allowedHeaders("location") // location 헤더를 허용
                .allowedHeaders("*") // 모든 헤더를 허용
                .allowCredentials(true);// 자격 증명(쿠키, 인증 헤더 등)을 포함한 요청을 허용
    }
}
