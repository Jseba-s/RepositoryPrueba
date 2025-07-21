package com.example.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebaTecnica.model.Producto;

@Repository
public interface IRepositoryProducto extends JpaRepository <Producto, Integer> {

}
