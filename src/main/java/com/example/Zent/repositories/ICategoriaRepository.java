package com.example.Zent.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Zent.modelos.Categoria;
import java.time.LocalDate;


@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>  {

    //condiero una consulta personalizada por ahora como una busqueda

    //1. defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar la busqueda
    //Buscar por nombre
    List<Categoria> findByNombres(String nombres);
    //Buscar por fecha de creacion
    List<Categoria> findByFechaCreacion(LocalDate fechaCreacion);
    //Buscar por responsable
    Optional<Categoria> findByResponsable(String responsable);
    //Buscar por codigo
    List<Categoria> findByCodigo(Integer codigo);
}
