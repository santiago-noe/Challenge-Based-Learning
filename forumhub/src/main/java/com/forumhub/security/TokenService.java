package com.forumhub.security;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    
    public String getSubject(String token) {
        return "usuario@email.com";
    }
}
