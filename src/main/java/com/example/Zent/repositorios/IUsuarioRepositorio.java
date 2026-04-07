package com.example.Zent.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Zent.modelos.Usuario;
import com.example.Zent.modelos.utils.TipoDeEstado;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
     
    //considero una consulta personalizada por ahora como una búsqueda 
    //1. Defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las búsquedas
    //2. buscar por nombre
    List<Usuario> findByNombres(String nombres);

    //3. buscar por tipo de documento
    List<Usuario> findByTipoDocumento(String tipoDocumento);

    //4. buscar por documento
    List<Usuario> findByDocumento(String documento);

    //5. buscar por edad
    List<Usuario> findByEdad(Integer edad);
    
    //Buscar por Estado
    List<Usuario> findByEstado(TipoDeEstado estado);


}
