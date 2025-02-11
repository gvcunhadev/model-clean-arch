package br.com.clean.arch.infra.gateways;

import br.com.clean.arch.application.gateways.RepositorioDeUsuario;
import br.com.clean.arch.domain.entities.usuario.Usuario;
import br.com.clean.arch.infra.persistence.UsuarioEntity;
import br.com.clean.arch.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
