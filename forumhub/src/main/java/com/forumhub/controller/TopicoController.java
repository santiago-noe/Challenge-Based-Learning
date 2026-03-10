package com.forumhub.controller;

import com.forumhub.dto.TopicoRequestDTO;
import com.forumhub.dto.TopicoResponseDTO;
import com.forumhub.dto.TopicoUpdateDTO;
import com.forumhub.service.TopicoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {
    
    @Autowired
    private TopicoService topicoService;
    
    @PostMapping
    public ResponseEntity<?> crearTopico(
            @RequestBody @Valid TopicoRequestDTO request,
            UriComponentsBuilder uriComponentsBuilder) {
        try {
            TopicoResponseDTO response = topicoService.crearTopico(request);
            URI url = uriComponentsBuilder.path("/api/topicos/{id}")
                .buildAndExpand(response.id())
                .toUri();
            return ResponseEntity.created(url).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopicos(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TopicoResponseDTO> topicos = topicoService.listarTopicos(pageable);
        return ResponseEntity.ok(topicos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopico(@PathVariable Long id) {
        try {
            TopicoResponseDTO topico = topicoService.obtenerTopico(id);
            return ResponseEntity.ok(topico);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid TopicoUpdateDTO updateDTO) {
        try {
            TopicoResponseDTO topicoActualizado = topicoService.actualizarTopico(id, updateDTO);
            return ResponseEntity.ok(topicoActualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        try {
            topicoService.eliminarTopico(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
