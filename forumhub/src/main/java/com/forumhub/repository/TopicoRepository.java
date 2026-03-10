package com.forumhub.repository;

import com.forumhub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    
    Page<Topico> findAllByActivoTrue(Pageable pageable);
    
    Optional<Topico> findByIdAndActivoTrue(Long id);
    
    @Query("SELECT t FROM Topico t WHERE t.titulo = :titulo AND t.mensaje = :mensaje AND t.activo = true")
    Optional<Topico> findByTituloAndMensaje(@Param("titulo") String titulo, @Param("mensaje") String mensaje);
    
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Topico t WHERE t.tituloMensajeUnique = :uniqueValue")
    boolean existsByTituloAndMensaje(@Param("uniqueValue") String uniqueValue);
}
