package com.example.Zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <?> controladorGuardar(@RequestBody Gasto datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_gasto(datos)
        );
    }

    //funcion controladora para el servicio de listar todos los gastos
    public ResponseEntity <?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos()
        );
    }
}
