package com.example.Zent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Zent.modelos.Comercio;
import com.example.Zent.repository.IComercioRepositorio;

@Service
public class ComercioServicios {

    @Autowired
    private IComercioRepositorio comercioRepositorio;

    public Comercio guardarComercio(Comercio datosComercio){
        //validar los campos del modelo segun la logica del negocio

        //validar que el comercio me mande su nit
        if(datosComercio.getNit()== null || datosComercio.getNit().isEmpty() || datosComercio.getNit().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el nit del comercio es obligatorio");
        }

        //validar que el nit tenga al menos 6 caracteres
        if(datosComercio.getNit().length()<6){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el nit del comercio debe tener mas de 6 caracteres");
        }
        //validar que el comercio me mande su nombre
        if(datosComercio.getNombre()== null || datosComercio.getNombre().isEmpty() || datosComercio.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el nombre del comercio es obligatorio");
        }
        //validar que el comercio me mande su actividad
        if(datosComercio.getActividad()== null || datosComercio.getActividad().isEmpty() || datosComercio.getActividad().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, la actividad del comercio es obligatoria");
        }
        //validar que el comercio me mande su ciudad
        if(datosComercio.getCiudad()== null || datosComercio.getCiudad().isEmpty() || datosComercio.getCiudad().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, la ciudad del comercio es obligatoria");
        }
        if(datosComercio.getEstado()== null || datosComercio.getEstado().isEmpty() || datosComercio.getEstado().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el estado del comercio es obligatorio");
        }

        //si paso todas las validaciones 
        //intentare activar el guardado de los datos
        return comercioRepositorio.save(datosComercio);
    }

    //funcion para listar todos los comercios
    public List<Comercio> listar_Comercios(){
        return comercioRepositorio.findAll();
    }

    //funcion para modificar un comercio
    //funcion para eliminar un comercio
    //funcion para buscar un comercio

}