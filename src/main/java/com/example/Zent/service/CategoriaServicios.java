package com.example.Zent.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Zent.modelos.Categoria;
import com.example.Zent.repository.ICategoriaRepo;

@Service
public class CategoriaServicios {
    //inyectando dependencia la repositorio categoria
    @Autowired
    private ICategoriaRepo categoriaRepo;

    //se programa cada funcion por cada servicio que voy a ofrecer

    //funcion para guardar una categoria
    public Categoria guardarCategoria(Categoria datosCategoria){
        //validar los campos del modelo segun la logica del negocio

        //validar que la categoria me mande su nombre
        if(datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank() || datosCategoria.getNombre().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "peticion invalida");
        }

        //validar que el responsable tenga mas de letras su anonimato
        if(datosCategoria.getResponsable().length() <  4){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El numero de cacteres tiene que ser mayor a 4");
        }
        //validar que la fecha no sea futura
        if(datosCategoria.getFechaCreacion().isAfter(LocalDate.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No tienes fecha correcta");
        }
        
        //si paso todas las validaciones 
        //intentare activar el guardado de los datos
        return categoriaRepo.save(datosCategoria);
    }

    //funcion para listar todas las categorias
    public List<Categoria> listar_Categorias(){
        return categoriaRepo.findAll();
    }
    
    //funcion para modificar un usuario
    //funcion para eliminar un usuario por id
    //funcion para buscar un usuario por id

}
