package com.example.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaTecnica.model.Producto;
import com.example.pruebaTecnica.repository.IRepositoryProducto;

//Creamos una clase para poder implementar los metodos de la interfaz IServiceProducto
@Service
public class ServiceProducto implements IServiceProducto{


    //Inyeccion de dependencias
    @Autowired
    private IRepositoryProducto repositoryProducto;
    @Override
    public List<Producto> traerProductos() {
        List<Producto> listaProductos = repositoryProducto.findAll();
        return listaProductos;
    }

    @Override
    public Producto traerProductoPorId(int id) {
        Producto producto = repositoryProducto.findById(id).orElse(null);
        return producto;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        repositoryProducto.save(producto);
        return producto;
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        Producto productoExistente = repositoryProducto.findById(producto.getId()).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setCantidad(producto.getCantidad());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setDescripcion(producto.getDescripcion());
            repositoryProducto.save(productoExistente);
        }
        return productoExistente;
    }

    @Override
    public void eliminarProducto(int id) {
        repositoryProducto.deleteById(id);
    }

}
