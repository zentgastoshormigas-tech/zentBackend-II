package com.example.Zent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zent.modelos.Categoria;
import java.time.LocalDate;
import com.example.Zent.modelos.utils.TipoDeEstado;



public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

    //considero una consulta personalizada por ahora como una búsqueda 
    //1. Defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las búsquedas
    //2. buscar por nombre

    List<Categoria> findByNombre(String nombre);
    List<Categoria> findByFechaCreacion(LocalDate fechaCreacion);
    List<Categoria> findByCodigo(Integer codigo);
    List<Categoria> findByEstado(TipoDeEstado estado);
    List<Categoria> findByResponsable(String responsable);
}