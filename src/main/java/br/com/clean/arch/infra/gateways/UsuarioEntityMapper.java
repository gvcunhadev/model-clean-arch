package br.com.clean.arch.infra.gateways;

import br.com.clean.arch.domain.entities.usuario.Usuario;
import br.com.clean.arch.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
    return new UsuarioEntity(
            usuario.getCpf(),
            usuario.getNome(),
            usuario.getNascimento(),
            usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity){
        return new Usuario(
                usuarioEntity.getCpf(),
                usuarioEntity.getNome(),
                usuarioEntity.getNascimento(),
                usuarioEntity.getEmail());
    }
}
