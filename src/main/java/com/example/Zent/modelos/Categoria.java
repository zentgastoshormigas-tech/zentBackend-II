package com.example.Zent.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.Zent.modelos.utils.TipoDeEstado;

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
@Table(name = "categoria")
public class Categoria {
// adicionar 5 campos considerados importantes
    //id, nombre, fechaCreacion, responsable, justificacion

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    private String nombre;
    @Column(name = "fecha_creacion", nullable = false, unique = false)
    private LocalDate fechaCreacion;
    @Column(name = "responsable", nullable = false, unique = false, length = 30)
    private String responsable;
    @Column(name = "justificacion", nullable = false, unique = false, length = 255)
    private String justificacion;
    @Column(name = "descripcion", nullable = false, unique = false, length = 255)
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoDeEstado estado;
    @Column(name = "fecha_modificacion", nullable = false, unique = false)
    private LocalDate fechaModificacion;
    @Column(name = "codigo", nullable = false, unique = false)
    private Integer codigo;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Gasto> gastos;
    
    
    
    public Categoria() {
    }


    public Categoria(Integer id, String nombre, LocalDate fechaCreacion, String responsable, String justificacion,
            String descripcion, TipoDeEstado estado, LocalDate fechaModificacion, Integer codigo, List<Gasto> gastos) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaModificacion = fechaModificacion;
        this.codigo = codigo;
        this.gastos = gastos;
    }


    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    public String getResponsable() {
        return responsable;
    }


    public String getJustificacion() {
        return justificacion;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public TipoDeEstado getEstado() {
        return estado;
    }


    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }


    public Integer getCodigo() {
        return codigo;
    }


    public List<Gasto> getGastos() {
        return gastos;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setEstado(TipoDeEstado estado) {
        this.estado = estado;
    }


    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    
    

}