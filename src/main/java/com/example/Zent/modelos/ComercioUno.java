package com.example.Zent.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.Zent.modelos.utils.TipoDeCiudad;
import com.example.Zent.modelos.utils.TipoDeEstado;
import com.example.Zent.modelos.utils.TipoDeRegimenTributario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "comercios")
public class ComercioUno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nit", nullable = false, unique = true, length = 255)
    private String nit;
    @Column(name = "nombre", nullable = false, unique = false, length = 255)
    private String nombre;
    @Column(name = "actividad", nullable = false, unique = false, length = 255)
    private String actividad; 
    @Column(name = "contacto", nullable = false, unique = false, length = 255)
    private String contacto;
    @Column(name = "direccion", nullable = false, unique = false, length = 255)
    private String direccion;
    @Column(name = "ciudad", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeCiudad ciudad; 
    @Column(name = "fecha_registro", nullable = false, unique = false)
    private LocalDate fechaRegistro;
    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TipoDeEstado estado; 
    @Column(name = "regimen_tributario", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoDeRegimenTributario regimenTributario; 


    @OneToMany(mappedBy = "comercio", fetch = FetchType.LAZY)
    private List<Gasto> gastos;


    public ComercioUno() {
    }


    public ComercioUno(Integer id, String nit, String nombre, String actividad, String contacto, String direccion,
            TipoDeCiudad ciudad, LocalDate fechaRegistro, TipoDeEstado estado,
            TipoDeRegimenTributario regimenTributario, List<Gasto> gastos) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.regimenTributario = regimenTributario;
        this.gastos = gastos;
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


    public TipoDeCiudad getCiudad() {
        return ciudad;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public TipoDeEstado getEstado() {
        return estado;
    }


    public TipoDeRegimenTributario getRegimenTributario() {
        return regimenTributario;
    }


    public List<Gasto> getGastos() {
        return gastos;
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


    public void setCiudad(TipoDeCiudad ciudad) {
        this.ciudad = ciudad;
    }


    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public void setEstado(TipoDeEstado estado) {
        this.estado = estado;
    }


    public void setRegimenTributario(TipoDeRegimenTributario regimenTributario) {
        this.regimenTributario = regimenTributario;
    }


    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    

    
}