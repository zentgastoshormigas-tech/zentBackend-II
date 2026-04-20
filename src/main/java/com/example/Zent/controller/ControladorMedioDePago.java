package com.example.Zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Zent.modelos.MedioDePago;
import com.example.Zent.service.MedioDePagoService;

@RestController
@RequestMapping("/apizent/v1/medioDePago")
public class ControladorMedioDePago {

    
    @Autowired
    MedioDePagoService medioDePago;
    
    public ResponseEntity <?> controladorGuardar(@RequestBody MedioDePago datos){

        return ResponseEntity.status(HttpStatus.OK).body(medioDePago.guardarMedioDePago(datos));
    }

    public ResponseEntity <?> controladorListar(){
        return ResponseEntity.status(HttpStatus.OK).body(medioDePago.listar_MedioDePago());
    }


}
