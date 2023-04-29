package com.example.java_experience.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_experience.model.Usuario;
import com.example.java_experience.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario criarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping(value="/contador")
    public long contador(){
        return usuarioRepository.count();
    }

    @GetMapping(value="/ordenarNomes")
    public List<Usuario> ordenarNomes(){
        return usuarioRepository.findByOrderByNome();
    }

    @GetMapping(value="/nomeContem")
    public List<Usuario> nomeContem() {
        return usuarioRepository.findByNomeContaining("lv");
    }

    @GetMapping
    public List<Usuario> obterUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(value="/email/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable(value = "email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarUsuarioPeloId(@PathVariable(value = "id") Long id) {
        usuarioRepository.deleteById(id);
        return "Usuário deletado com sucesso!";
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    
    
}
