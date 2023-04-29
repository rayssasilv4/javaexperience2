package com.example.java_experience.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java_experience.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

    List<TipoUsuario> findByOrderByNome();
    
}
