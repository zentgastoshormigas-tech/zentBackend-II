package com.example.Zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Zent.modelos.Categoria;
import com.example.Zent.service.CategoriaServicios;

@RestController
@RequestMapping("/apizent/v1/categorias")
public class ControladorCategoria {
    @Autowired
    CategoriaServicios categoria;

    //Por cada servicio programa un metodo
    //para recibir y enviar respuestas al cliente
    @PostMapping
    public ResponseEntity <?> controladorGuardar(@RequestBody Categoria datos){

        return ResponseEntity.status(HttpStatus.OK).body(categoria.guardarCategoria(datos));

    }
    @GetMapping
    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(categoria.listar_Categorias());
    }

    //control para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Categoria datos){
        return ResponseEntity.status(HttpStatus.OK).body(categoria.modificar_categoria(id, datos));
    }

    //control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorElimnar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(categoria.eliminar_categoria(id));
    }


    //control para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controlador_buscar_por_id(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(categoria.buscar_categoria_por_id(id));
    }
}
