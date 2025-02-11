package br.com.clean.arch.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioEntityTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario(
                        "123456789-99",
                        "Jacque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario(
                        "123456.789-99",
                        "Jacque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario(
                        "",
                        "Jacque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento(
                "Emily",
                "234.345.233-99",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily",usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-999", 40, "apto 201");

        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }

}

