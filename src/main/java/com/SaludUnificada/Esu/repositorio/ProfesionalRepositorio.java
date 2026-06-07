package com.SaludUnificada.Esu.repositorio;

import com.SaludUnificada.Esu.entidad.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepositorio extends JpaRepository<Profesional, Long> {
}