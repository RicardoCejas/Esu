package com.SaludUnificada.Esu.mapper;

import com.SaludUnificada.Esu.dto.request.ProfesionalDtoRequest;
import com.SaludUnificada.Esu.dto.response.ProfesionalDtoResponse; // Importación corregida
import com.SaludUnificada.Esu.entidad.Especialidad;
import com.SaludUnificada.Esu.entidad.Profesional;
import com.SaludUnificada.Esu.servicio.IEspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfesionalMapper {

    @Autowired
    private IEspecialidadServicio especialidadServicio;

    @Autowired
    private EspecialidadMapper especialidadMapper;

    public Profesional paraEntidad(ProfesionalDtoRequest dto) {
        Profesional profesional = new Profesional();
        profesional.setNombre(dto.getNombre());
        profesional.setApellido(dto.getApellido());
        profesional.setMatricula(dto.getMatricula());
        profesional.setTelefono(dto.getTelefono());

        if (dto.getEspecialidadId() != null) {
            Especialidad especialidad = especialidadServicio.obtenerEntidadEspecialidadPorId(dto.getEspecialidadId());
            profesional.getEspecialidades().add(especialidad);
        }

        return profesional;
    }

    public ProfesionalDtoResponse paraDto(Profesional profesional) { // Tipo de retorno corregido
        ProfesionalDtoResponse dto = new ProfesionalDtoResponse(); // Instanciación corregida
        dto.setId(profesional.getId());
        dto.setNombre(profesional.getNombre());
        dto.setApellido(profesional.getApellido());
        dto.setMatricula(profesional.getMatricula());
        dto.setTelefono(profesional.getTelefono());

        if (!profesional.getEspecialidades().isEmpty()) {
            Especialidad especialidad = profesional.getEspecialidades().iterator().next();
            dto.setEspecialidad(especialidadMapper.paraDto(especialidad));
        }

        return dto;
    }
    // El método paraResumenDto ha sido eliminado por ser redundante.
}
