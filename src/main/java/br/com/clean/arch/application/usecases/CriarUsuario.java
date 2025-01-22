package br.com.clean.arch.application.usecases;

import br.com.clean.arch.application.gateways.RepositorioDeUsuario;
import br.com.clean.arch.domain.entities.usuario.Usuario;


public class CriarUsuario {
    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
}
