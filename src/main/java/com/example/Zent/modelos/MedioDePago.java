package com.example.Zent.modelos;

import com.example.Zent.modelos.utils.TipoFranquicia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medio_de_pago")
public class MedioDePago {
    //id, nombre, franquicia, estado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombres_completos", nullable = false, unique = false, length = 100)
    private String nombre;
    @Column(name = "nombres_completos", nullable = false, unique = false, length = 30)
    @Enumerated(EnumType.STRING)
    private TipoFranquicia franquicia;
    @Column(name = "nombres_completos", nullable = false, unique = false)
    private Boolean estado;
    
    
    public MedioDePago() {
    }


    public MedioDePago(Integer id, String nombre, TipoFranquicia franquicia, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public TipoFranquicia getFranquicia() {
        return franquicia;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setFranquicia(TipoFranquicia franquicia) {
        this.franquicia = franquicia;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    

    

    
}