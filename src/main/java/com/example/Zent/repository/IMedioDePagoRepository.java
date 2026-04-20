package com.example.Zent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zent.modelos.MedioDePago;
import com.example.Zent.modelos.utils.TipoFranquicia;

public interface IMedioDePagoRepository extends JpaRepository<MedioDePago, Integer>{

    //considero una consulta personalizada por ahora como una búsqueda 
    //1. Defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las búsquedas
    //2. buscar por nombre

    List<MedioDePago> findByNombre(String nombre);
    List<MedioDePago> findByFranquicia(TipoFranquicia franquicia);
    List<MedioDePago> findByEstado(Boolean estado);
}
