package com.example.pruebaTecnica.service;

import java.util.List;

import com.example.pruebaTecnica.model.Producto;

//Crear metodos basicos de un CRUD para la entidad Producto
public interface IServiceProducto {

    List<Producto> traerProductos();
    Producto traerProductoPorId(int id);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(int id);

}
