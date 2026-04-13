package com.example.Zent.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Zent.modelos.Usuario;
import com.example.Zent.modelos.utils.TipoDocumento;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    //condiero una consulta personalizada por ahora como una busqueda

    //1. defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar la busqueda
    //Buscar por nombre
    List<Usuario> findByNombres(String nombres);
    //Buscar por tipo de documento
    List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento);
    //Buscar por documento
    Optional<Usuario> findByDocumento(String documento);
    //Buscar por edad
    List<Usuario> findByEdad(Integer edad);




}
