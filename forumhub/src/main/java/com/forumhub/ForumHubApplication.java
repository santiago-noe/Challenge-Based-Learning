package com.forumhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumHubApplication.class, args);
        System.out.println("=================================");
        System.out.println("🚀 ForumHub API iniciada!");
        System.out.println("🌐 http://localhost:8080");
        System.out.println("📚 Endpoints disponibles:");
        System.out.println("   POST   /api/topicos");
        System.out.println("   GET    /api/topicos");
        System.out.println("   GET    /api/topicos/{id}");
        System.out.println("   PUT    /api/topicos/{id}");
        System.out.println("   DELETE /api/topicos/{id}");
        System.out.println("=================================");
    }
}
