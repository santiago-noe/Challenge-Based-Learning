package com.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoUpdateDTO(
    @NotBlank(message = "El título es obligatorio")
    String titulo,
    
    @NotBlank(message = "El mensaje es obligatorio")
    String mensaje
) {}
