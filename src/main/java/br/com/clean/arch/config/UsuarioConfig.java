package br.com.clean.arch.config;

import br.com.clean.arch.application.gateways.RepositorioDeUsuario;
import br.com.clean.arch.application.usecases.CriarUsuario;
import br.com.clean.arch.application.usecases.ListarUsuarios;
import br.com.clean.arch.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.clean.arch.infra.gateways.UsuarioEntityMapper;
import br.com.clean.arch.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapper(){
        return new UsuarioEntityMapper();
    }



}
