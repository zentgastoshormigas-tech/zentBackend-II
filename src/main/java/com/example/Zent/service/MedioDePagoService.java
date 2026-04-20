package com.example.Zent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Zent.modelos.MedioDePago;
import com.example.Zent.repository.IMedioDePagoRepository;

@Service
public class MedioDePagoService {

    @Autowired
    private IMedioDePagoRepository medioDePagoRepositorio;


    public MedioDePago guardarMedioDePago(MedioDePago pago){
        //VALIDAR LOS CAMPOS DEL MODELO SEGUN LA LOGICA DE NEGOCIO
        if(pago == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario los datos de pagos son obligatorio");
        }

        //Validar que metodo de pago 
        if(pago.getNombre() == null || pago.getNombre().isEmpty() || pago.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, el nombre es obligatorio");

        }

        //validar que el medio de pago mande su franquicia
        if (pago.getFranquicia() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, la franquicia del medio de pago es obligatoria");

        }

        //si paso todas las validaciones 
        //intentare activar el guardado de los datos

        return medioDePagoRepositorio.save(pago);

    }

    public List<MedioDePago> listar_MedioDePago(){
        return medioDePagoRepositorio.findAll();

    }

    //funcion para modificar un Medio De Pago
    //funcion para eliminar un Medio De Pago
    //funcion para buscar un Medio De Pago

}
