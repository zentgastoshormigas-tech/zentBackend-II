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

import com.example.Zent.modelos.Gasto;
import com.example.Zent.service.GastosServicios;

@RestController
@RequestMapping("/apizent/v1/gastos")
public class ControladorGasto {
    @Autowired
    GastosServicios servicio;

    //por cada gasto programo un metodo para recibir y enviar respuestas al cliente

    //funcion controladora para el servicio de guardar gasto
    @PostMapping
    public ResponseEntity <?> controladorGuardar(@RequestBody Gasto datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardarGasto(datos)
        );
    }

    //funcion controladora para el servicio de listar todos los gastos
    @GetMapping
    public ResponseEntity <?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> controladorModificar(@PathVariable Integer id,@RequestBody Gasto datos) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.modificarGasto(id, datos)
            );
    }
@DeleteMapping("/{id}")
    public ResponseEntity <?> controladorEliminar(@PathVariable Integer id) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.eliminarGasto(id)
            );
    }
    @GetMapping("/{id}")
    public ResponseEntity <?> controladorBuscarID(@PathVariable Integer id) {
            return ResponseEntity.status(HttpStatus.OK).body(
                servicio.buscarGastoPorId(id)
            );
    }

}
