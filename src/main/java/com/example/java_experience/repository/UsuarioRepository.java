package com.example.java_experience.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java_experience.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByOrderByNome();

    List<Usuario> findByNomeContaining(String termo);
    
    
}
