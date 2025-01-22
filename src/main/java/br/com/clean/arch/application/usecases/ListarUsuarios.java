package br.com.clean.arch.application.usecases;

import br.com.clean.arch.application.gateways.RepositorioDeUsuario;
import br.com.clean.arch.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

     public List<Usuario> obterTodosUsuario(){
        return this.repositorio.listarTodos();
    }
}
