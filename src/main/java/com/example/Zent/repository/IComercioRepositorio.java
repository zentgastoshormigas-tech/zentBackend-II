package com.example.Zent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zent.modelos.ComercioUno;

public interface IComercioRepositorio extends JpaRepository<ComercioUno, Integer>{
    //considero una consulta personalizada por ahora como una búsqueda 
    //1. Defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las búsquedas
    //2. buscar por nombre

    List<ComercioUno> findByNombre(String nombre);
    List<ComercioUno> findByNit(String nit);
    List<ComercioUno> findByActividad(String actividad);
    List<ComercioUno> findByCiudad(String ciudad);
    List<ComercioUno> findByEstado(String estado);

}