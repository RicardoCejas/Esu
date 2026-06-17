package com.esu.mapper;

import com.esu.dto.UsuarioDtoRequest;
import com.esu.dto.UsuarioDtoResponse;
import com.esu.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario paraEntidad(UsuarioDtoRequest dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPasswordHash(dto.getPassword());
        return usuario;
    }

    public UsuarioDtoResponse paraDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDtoResponse dto = new UsuarioDtoResponse();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}
