package com.forumhub.dto;

import com.forumhub.model.StatusTopico;
import java.time.LocalDateTime;

public record TopicoResponseDTO(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaCreacion,
    StatusTopico status,
    UsuarioDTO autor,
    CursoDTO curso,
    Boolean activo
) {}
