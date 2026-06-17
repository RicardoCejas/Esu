package com.SaludUnificada.Esu.repositorio;

import com.SaludUnificada.Esu.entidad.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime; // Importación necesaria para LocalDateTime
import java.util.List; // Importación necesaria para List

@Repository
public interface HistoriaClinicaRepositorio extends JpaRepository<HistoriaClinica, Long> {
    // Query Method para buscar historias clínicas por el ID del paciente
    List<HistoriaClinica> findByPacienteId(Long pacienteId);

    // Query Method para buscar historias clínicas dentro de un rango de fechas de atención
    List<HistoriaClinica> findByFechaAtencionBetween(LocalDateTime inicio, LocalDateTime fin);
}