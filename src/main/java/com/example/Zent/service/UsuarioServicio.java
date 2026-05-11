package com.example.Zent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Zent.modelos.Usuario;
import com.example.Zent.repository.IUsuarioRepositorio;

@Service
public class UsuarioServicio {
    //Inyectando la dependencia del repositorio de usuario
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    //se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar un usuario
    public Usuario guardarUsuario(Usuario datosUsuario){
        //validar los campos del modelo segun la logica del negocio

        //validar que el usuario me mande sus nombres
        if(datosUsuario.getNombres()== null || datosUsuario.getNombres().isEmpty() || datosUsuario.getNombres().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el nombre de usuario es obligatorio");
        }

        //validar que el documento tenga al menos 6 caracteres
        if(datosUsuario.getDocumento() == null || datosUsuario.getDocumento().length()<6){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apreciado usuario, el documento debe tener mas de 6 caracteres");
        }

        //si paso todas las validaciones 
        //intentare activar el guardado de los datos
        return usuarioRepositorio.save(datosUsuario);

    }
    //funcion para listar todos los usuarios
    public List<Usuario> listar_Usuarios(){
        return usuarioRepositorio.findAll();
    }
    //funcion para modificar un usuario
    public Usuario modificar_Usuario(Integer id, Usuario datosNuevos){

        Optional<Usuario> usuario_que_busco = usuarioRepositorio.findById(id);
        if(usuario_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario no encontrado");
        }else{
            Usuario usuario_encontrado = usuario_que_busco.get();
            //modifiquemos datos
            usuario_encontrado.setNombres(datosNuevos.getNombres());
            usuario_encontrado.setTipoDocumento(datosNuevos.getTipoDocumento());
            return usuarioRepositorio.save(usuario_encontrado);
        }

    }


    //funcion para eliminar un usuario por id
    public boolean eliminar_usuario_por_id(Integer id){
        
        Optional<Usuario> usuario_que_busco = usuarioRepositorio.findById(id);
        if(usuario_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario no encontrado");
        }else{
            usuarioRepositorio.deleteById(id);
            return true;
        }
    }

    //funcion para buscar un usuario por id
    public Usuario buscar_usuario_por_id(Integer id){
        
        Optional<Usuario> usuario_que_busco = usuarioRepositorio.findById(id);
        if(usuario_que_busco.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario no encontrado");
        }else{
            return usuario_que_busco.get();
        }

    }
}
