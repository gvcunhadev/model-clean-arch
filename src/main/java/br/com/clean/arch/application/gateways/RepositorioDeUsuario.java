package br.com.clean.arch.application.gateways;



import br.com.clean.arch.domain.entities.usuario.Usuario;


import java.util.List;


public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
