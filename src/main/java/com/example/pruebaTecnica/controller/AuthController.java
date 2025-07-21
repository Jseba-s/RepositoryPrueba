package com.example.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaTecnica.model.LoginRequest;
import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.repository.IRepositoryUsuario;
import com.example.pruebaTecnica.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

     @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        repositoryUsuario.save(usuario);
        return "Usuario registrado";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        return jwtUtil.generarToken(request.getEmail());
    }
}


