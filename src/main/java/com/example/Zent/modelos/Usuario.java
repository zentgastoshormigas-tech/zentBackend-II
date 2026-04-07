package com.example.Zent.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.Zent.modelos.utils.TipoDeEstado;
import com.example.Zent.modelos.utils.TipoDocumento;

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
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres_completos", nullable = false, unique = false, length = 50)
    private String nombres;

    @Column(name = "tipo_documento", nullable = false, unique = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento", nullable = false, unique = true, length = 20)
    private String documento;

    @Column(name = "edad", nullable = false, unique = false, length = 3)
    private Integer edad;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "fecha_nacimiento", nullable = false, unique = false)
    private LocalDate fechaNacimiento;

    @Column(name = "telefono", nullable = false, unique = false, length = 20)
    private String telefono;

    @Column(name = "fecha_registro", nullable = false, unique = false)
    private LocalDate fechaRegistro;

    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TipoDeEstado estado;

    
    //creando una relacion con el modelo de gastos
    //yo como usuario me relaciono con muchos gastos

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Gasto> gastos;

    public Usuario() {
        this.gastos = new java.util.ArrayList<>();
    }

    public Usuario(String correo, String documento, Integer edad, TipoDeEstado estado, LocalDate fechaNacimiento, LocalDate fechaRegistro, String nombres, String telefono, TipoDocumento tipoDocumento) {
        this.correo = correo;
        this.documento = documento;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.nombres = nombres;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
        this.gastos = new java.util.ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TipoDeEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoDeEstado estado) {
        this.estado = estado;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    
}