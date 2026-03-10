package com.forumhub.service;

import com.forumhub.dto.*;
import com.forumhub.model.Topico;
import com.forumhub.model.Usuario;
import com.forumhub.model.Curso;
import com.forumhub.repository.TopicoRepository;
import com.forumhub.repository.UsuarioRepository;
import com.forumhub.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @Transactional
    public TopicoResponseDTO crearTopico(TopicoRequestDTO request) {
        String uniqueValue = request.titulo() + "_" + request.mensaje();
        if (topicoRepository.existsByTituloAndMensaje(uniqueValue)) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
        }
        
        Usuario autor = usuarioRepository.findById(request.autorId())
            .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado"));
        
        Curso curso = cursoRepository.findById(request.cursoId())
            .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado"));
        
        Topico topico = new Topico();
        topico.setTitulo(request.titulo());
        topico.setMensaje(request.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);
        
        topico = topicoRepository.save(topico);
        
        return convertirADTO(topico);
    }
    
    public Page<TopicoResponseDTO> listarTopicos(Pageable pageable) {
        return topicoRepository.findAllByActivoTrue(pageable)
            .map(this::convertirADTO);
    }
    
    public TopicoResponseDTO obtenerTopico(Long id) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id)
            .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));
        return convertirADTO(topico);
    }
    
    @Transactional
    public TopicoResponseDTO actualizarTopico(Long id, TopicoUpdateDTO updateDTO) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id)
            .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));
        
        String uniqueValue = updateDTO.titulo() + "_" + updateDTO.mensaje();
        if (!topico.getTitulo().equals(updateDTO.titulo()) || 
            !topico.getMensaje().equals(updateDTO.mensaje())) {
            if (topicoRepository.existsByTituloAndMensaje(uniqueValue)) {
                throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
            }
        }
        
        topico.setTitulo(updateDTO.titulo());
        topico.setMensaje(updateDTO.mensaje());
        
        topico = topicoRepository.save(topico);
        
        return convertirADTO(topico);
    }
    
    @Transactional
    public void eliminarTopico(Long id) {
        Topico topico = topicoRepository.findByIdAndActivoTrue(id)
            .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));
        
        topico.setActivo(false);
        topicoRepository.save(topico);
    }
    
    private TopicoResponseDTO convertirADTO(Topico topico) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
            topico.getAutor().getId(),
            topico.getAutor().getNombre(),
            topico.getAutor().getEmail()
        );
        
        CursoDTO cursoDTO = new CursoDTO(
            topico.getCurso().getId(),
            topico.getCurso().getNombre(),
            topico.getCurso().getCategoria()
        );
        
        return new TopicoResponseDTO(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getStatus(),
            usuarioDTO,
            cursoDTO,
            topico.getActivo()
        );
    }
}
