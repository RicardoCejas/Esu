package com.SaludUnificada.Esu.controlador;

import com.SaludUnificada.Esu.dto.request.ProfesionalDtoRequest;
import com.SaludUnificada.Esu.dto.response.ProfesionalDtoResponse; // Importación corregida
import com.SaludUnificada.Esu.servicio.IProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalControlador {

    @Autowired
    private IProfesionalServicio profesionalServicio;

    @PostMapping("/crear")
    public ResponseEntity<ProfesionalDtoResponse> crearProfesional(@RequestBody ProfesionalDtoRequest profesionalDto) { // Tipo de retorno corregido
        ProfesionalDtoResponse nuevoProfesional = profesionalServicio.crearProfesional(profesionalDto);
        return new ResponseEntity<>(nuevoProfesional, HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ProfesionalDtoResponse> obtenerProfesionalPorId(@PathVariable Long id) { // Tipo de retorno corregido
        try {
            ProfesionalDtoResponse profesional = profesionalServicio.obtenerProfesionalPorId(id);
            return new ResponseEntity<>(profesional, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtener/todos")
    public ResponseEntity<List<ProfesionalDtoResponse>> listarTodos() { // Tipo de retorno corregido
        List<ProfesionalDtoResponse> profesionales = profesionalServicio.listarTodos();
        return new ResponseEntity<>(profesionales, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProfesional(@PathVariable Long id) {
        try {
            profesionalServicio.eliminarProfesional(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filtrar/especialidad/{especialidadId}")
    public ResponseEntity<List<ProfesionalDtoResponse>> filtrarPorEspecialidad(@PathVariable Long especialidadId) { // Tipo de retorno corregido
        List<ProfesionalDtoResponse> profesionales = profesionalServicio.filtrarPorEspecialidad(especialidadId);
        return new ResponseEntity<>(profesionales, HttpStatus.OK);
    }
}
