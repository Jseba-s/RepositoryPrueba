package com.example.pruebaTecnica.service;

import java.util.List;

import com.example.pruebaTecnica.model.Usuario;

//Crear metodos basicos de un CRUD para la entidad Usuario
public interface IServiceUsuario {

    public Usuario crearUsuario(Usuario usuario);

    public void eliminarUsuario(int id);

    public Usuario actualizarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorId(int id);

    public List<Usuario> obtenerTodosUsuarios();

}
