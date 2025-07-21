package com.example.pruebaTecnica.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.repository.IRepositoryUsuario;

//Cargar los detalles del usuario desde la base de datos

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    // Metodo para cargar el usuario por su nombre de usuario (email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositoryUsuario.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new org.springframework.security.core.userdetails.User(
            usuario.getEmail(),
            usuario.getPassword(),
            new ArrayList<>() 
        );
    }

}
