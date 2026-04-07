
package com.example.Zent.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.Zent.modelos.Gasto;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "comercios")

public class Comercio {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nit", nullable = false, unique = true, length = 20)
    private String nit;
    @Column(name = "nombre", nullable = false, unique = false, length = 255)
    private String nombre;
    @Column(name = "actividad", nullable = false, unique = false, length = 255)
    private String actividad; 
    @Column(name = "contacto", nullable = true, unique = false, length = 255)
    private String contacto;
    @Column(name = "direccion", nullable = true, unique = false, length = 255)
    private String direccion;
    @Column(name = "ciudad", nullable = false, unique = false, length = 255)
    private String ciudad; 
    @Column(name = "fecha_registro", nullable = false, unique = false)
    private LocalDate fechaRegistro;
    @Column(name = "estado", nullable = false, unique = false, length = 255)
    private String estado; 
    @Column(name = "regimen_tributario", nullable = true, length = 255)
    private String regimenTributario; 


    @OneToMany(mappedBy = "comercio", fetch = FetchType.LAZY)
    private List<Gasto> gastos;


    public Comercio() {
        this.gastos = new java.util.ArrayList<>();
    }


    public Comercio(String nit, String nombre, String actividad, String contacto, String direccion,
           String ciudad, LocalDate fechaRegistro, String estado, String regimenTributario) {
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.regimenTributario = regimenTributario;
        this.gastos = new java.util.ArrayList<>();
    }


    public Integer getId() {
        return id;
    }


    public String getNit() {
        return nit;
    }


    public String getNombre() {
        return nombre;
    }


    public String getActividad() {
        return actividad;
    }


    public String getContacto() {
        return contacto;
    }


    public String getDireccion() {
        return direccion;
    }


    public String getCiudad() {
        return ciudad;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public String getEstado() {
        return estado;
    }


    public String getRegimenTributario() {
        return regimenTributario;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setNit(String nit) {
        this.nit = nit;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setActividad(String actividad) {
        this.actividad = actividad;
    }


    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void setRegimenTributario(String regimenTributario) {
        this.regimenTributario = regimenTributario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    

}