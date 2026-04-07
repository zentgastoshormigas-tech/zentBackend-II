package com.example.Zent.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Zent.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {
    //Inyectando la dependencia del repositorio de usuario
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    //se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar un usuario
    //funcion para listar todos los usuarios
    //funcion para modificar un usuario
    //funcion para eliminar un usuario por id
    //funcion para buscar un usuario por id
}
