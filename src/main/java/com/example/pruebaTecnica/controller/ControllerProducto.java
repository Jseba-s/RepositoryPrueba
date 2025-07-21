package com.example.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaTecnica.model.Producto;
import com.example.pruebaTecnica.service.ServiceProducto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


// Controlador para manejar las peticiones relacionadas con la entidad Producto

@RestController
public class ControllerProducto {

    // Inyección de dependencias del servicio ServiceProducto implementando la logica de negocio
    @Autowired
    private ServiceProducto serviceProducto;

    @GetMapping("api/productos/traerProductos")
    public List<Producto>traerproductos() {
        List<Producto> listaProductos = serviceProducto.traerProductos();
        return listaProductos;
    }

    @PostMapping("api/productos/crearProducto")
    public String crearProductos(@RequestBody Producto producto) {
        serviceProducto.crearProducto(producto);
        return "El producto ha sido creado correctamente";
    }

    @PutMapping("api/productos/actualizarProducto/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto productoActualizado = serviceProducto.actualizarProducto(producto);
        return productoActualizado;
    }
    
    @DeleteMapping("api/productos/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable int id) {
        serviceProducto.eliminarProducto(id);
        return "El producto ha sido eliminado correctamente";
    }
}
