package com.SaludUnificada.Esu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate; // Importación agregada

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDtoResponse {
    private Long id;
    private String username; // Corresponde al email de la entidad Usuario
    private String rol; // Agregado
    private Boolean activo;
    private LocalDate fechaDeAlta; // Agregado
}
