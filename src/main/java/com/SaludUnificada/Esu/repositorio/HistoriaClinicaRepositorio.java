package com.SaludUnificada.Esu.repositorio;

import com.SaludUnificada.Esu.entidad.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepositorio extends JpaRepository<HistoriaClinica, Long> {
}