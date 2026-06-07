package com.SaludUnificada.Esu.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(name = "nro_afiliado", nullable = false, unique = true)
    private String nroAfiliado;

    // Paciente es el dueño de la relación con Usuario (tiene la FK)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id", nullable = false, unique = true)
    private Usuario usuario;

    // Paciente es el dueño de la relación con HistoriaClinica (tiene la FK)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_historia_clinica", referencedColumnName = "id", nullable = false, unique = true)
    private HistoriaClinica historiaClinica;
}