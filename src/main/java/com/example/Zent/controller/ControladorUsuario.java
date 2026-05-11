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

import com.example.Zent.modelos.Usuario;
import com.example.Zent.service.UsuarioServicio;
@RestController
@RequestMapping("/apizent/v1/usuarios")
public class ControladorUsuario {
    @Autowired
    UsuarioServicio servicio;

    //por cada usuario programo un metodo para recibir y enviar respuestas al cliente

    //Funcion controladora para el servicio de guardar usuario
    @PostMapping
    public ResponseEntity <?> controladorGuardar(@RequestBody Usuario datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardarUsuario(datos)
        );
    }

    //funcion controladora para el servicio de listar todos los usuarios
    @GetMapping
    public ResponseEntity <?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Usuarios()
        );
    }

    //control para modificar
    @PutMapping("/{id}")
    public ResponseEntity <?> controladorModificar(@PathVariable Integer id,@RequestBody Usuario datos) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.modificar_Usuario(id, datos)
            );
    }

    //control para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity <?> controladorEliminar(@PathVariable Integer id) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.eliminar_usuario_por_id(id)
            );
    }

    //control para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity <?> controladorBuscarID(@PathVariable Integer id) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.buscar_usuario_por_id(id)
            );
    }

}
