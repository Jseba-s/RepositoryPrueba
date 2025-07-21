package com.example.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.service.ServiceUsuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



// Controlador para manejar las peticiones relacionadas con la entidad Usuario
@RestController
public class ControllerUsuario {

    // Inyección de dependencias del servicio ServiceUsuario implementando la logica de negocio
    @Autowired
    private ServiceUsuario serviceUsuario;


    @GetMapping("usuarios/traerUsuarios")
    public List<Usuario> listaUsuarios () {
        List<Usuario> listausuarios = serviceUsuario.obtenerTodosUsuarios();
        return listausuarios;
    }
    
    @PostMapping("usuarios/crearUsuario")
    public String crearUsuario(@RequestBody Usuario usuario) {
        serviceUsuario.crearUsuario(usuario);
        return "El usuario ha sido creado correctamente";        
    }

    @PutMapping("usuario/actualizarUsuario/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario usuarioActualizado = serviceUsuario.actualizarUsuario(usuario);         
        return usuarioActualizado;
    }

    @DeleteMapping("usuario/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable String id) {
        int idUsuario = Integer.parseInt(id);
        serviceUsuario.eliminarUsuario(idUsuario);
        return "El usuario ha sido eliminado correctamente";
    }
    
}
