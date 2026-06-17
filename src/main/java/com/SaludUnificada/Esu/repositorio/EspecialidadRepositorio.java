package com.SaludUnificada.Esu.repositorio;

import com.SaludUnificada.Esu.entidad.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Importación necesaria para List

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long> {
    // Query Method para buscar especialidades por nombre ignorando mayúsculas/minúsculas
    List<Especialidad> findByNombreContainingIgnoreCase(String nombre);
}