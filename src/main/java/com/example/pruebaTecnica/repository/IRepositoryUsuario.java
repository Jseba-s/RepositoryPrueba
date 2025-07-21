package com.example.pruebaTecnica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebaTecnica.model.Usuario;

@Repository
public interface IRepositoryUsuario extends JpaRepository <Usuario, Integer> {
    // Método para buscar un usuario por su email
    Optional<Usuario> findByEmail(String email);

}
