package com.example.Zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Zent.modelos.Categoria;
import com.example.Zent.service.CategoriaServicios;

@RestController
@RequestMapping("/apizent/v1/cateogias")
public class ControladorCategoria {
    @Autowired
    CategoriaServicios categoria;

    //Por cada servicio programa un metodo
    //para recibir y enviar respuestas al cliente

    public ResponseEntity <?> controladorGuardar(@RequestBody Categoria datos){

        return ResponseEntity.status(HttpStatus.OK).body(categoria.guardarCategoria(datos));

    }

    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(categoria.listar_Categorias());
    }
}
