package com.example.Zent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zent.modelos.Comercio;

public interface IComercioRepositorio extends JpaRepository<Comercio, Integer>{
    //considero una consulta personalizada por ahora como una búsqueda 
    //1. Defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las búsquedas
    //2. buscar por nombre

    List<Comercio> findByNombre(String nombre);
    List<Comercio> findByNit(String nit);
    List<Comercio> findByActividad(String actividad);
    List<Comercio> findByCiudad(String ciudad);
    List<Comercio> findByEstado(String estado);

}