package com.example.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.repository.IRepositoryUsuario;


// Creamos una clase para poder implementar los metodos de la interfaz IServiceUsuario
@Service
public class ServiceUsuario implements IServiceUsuario{

    // Inyección de dependencias
    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        repositoryUsuario.save(usuario);
        return usuario;
    }

    @Override
    public void eliminarUsuario(int id) {
       repositoryUsuario.deleteById(id);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioExistente = repositoryUsuario.findById(usuario.getId()).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword());
            repositoryUsuario.save(usuarioExistente);
        }
        return usuarioExistente;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = repositoryUsuario.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> listausuarios = repositoryUsuario.findAll();
        return listausuarios;
    }

}
