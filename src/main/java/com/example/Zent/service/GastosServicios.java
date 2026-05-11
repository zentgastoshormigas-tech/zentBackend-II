package com.example.Zent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Zent.modelos.Gasto;
import com.example.Zent.repository.IGastoRepositorio;

@Service
public class GastosServicios {
    @Autowired
    private IGastoRepositorio gastoRepositorio;

    public Gasto guardarGasto(Gasto datosGasto){
        if(datosGasto == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, el gasto no puede ser vacío");
        }

        if(datosGasto.getValor() == null || datosGasto.getValor() <= 500){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, el gasto debe ser superior a 500 pesos colombianos");
        }

        if(datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, la descripción del gasto no puede estar vacía");
        }

        if(datosGasto.getFechaRegistro() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apreciado usuario, la fecha de registro del gasto es obligatoria");
        }

        return gastoRepositorio.save(datosGasto);
    }

    public Gasto buscarGastoPorId(Integer id) {
    return gastoRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gasto no encontrado"));
    }

    public List<Gasto> listar_gastos() {
        return gastoRepositorio.findAll();
    }


    public Gasto modificarGasto(Integer id, Gasto datosNuevos) {
        Optional<Gasto> gasto_que_busco = gastoRepositorio.findById(id);
        if(gasto_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gasto no encontrado");
        }else{
            Gasto gasto_encontrado = gasto_que_busco.get();
            //modifiquemos datos
            gasto_encontrado.setDescripcion(datosNuevos.getDescripcion());
            gasto_encontrado.setValor(datosNuevos.getValor());
            return gastoRepositorio.save(gasto_encontrado);
        }
    }


    public boolean eliminarGasto(Integer id) {
        Optional<Gasto> gasto_que_busco = gastoRepositorio.findById(id);
        if(gasto_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gasto no encontrado");
        }else{
            gastoRepositorio.deleteById(id);
            return true;
        }
    }

    public Gasto buscar_gasto_id(Integer id){
        Optional<Gasto> gasto_que_busco = gastoRepositorio.findById(id);
        if(gasto_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gasto no encontrado");
        }else{
            return gasto_que_busco.get();
        }   
    }

}
