package com.example.Zent.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", nullable = true, unique = false, length = 255)
    private String descripcion;

    @Column(name = "fecha_registro", nullable = false, unique = false)
    private LocalDate fechaRegistro;

    @Column(name = "valor", nullable = false, unique = false, precision = 10, scale = 2)
    private Double valor;

    @Column(name = "imagen", nullable = true, unique = false, length = 255)
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "establecimiento", nullable = true, unique = false, length = 255)
    private String establecimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medio_pago_id")
    private MedioDePago medioPago;

    @Column(name = "notas", nullable = true, unique = false, length = 255)
    private String notas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    //creando una relacion con el modelo de usuario
    //yo como gasto me relaciono con un usuario, es decir, un gasto pertenece a un usuario

    public Gasto() {
    }

    public Gasto(String descripcion, LocalDate fechaRegistro, Double valor, String imagen, Categoria categoria, String establecimiento, MedioDePago medioPago, String notas, Usuario usuario, Comercio comercio) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.valor = valor;
        this.imagen = imagen;
        this.categoria = categoria;
        this.establecimiento = establecimiento;
        this.medioPago = medioPago;
        this.notas = notas;
        this.usuario = usuario;
        this.comercio = comercio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public MedioDePago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioDePago medioPago) {
        this.medioPago = medioPago;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

}