package com.example.Zent.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zent.modelos.Gasto;


public interface IGastoRepositorio extends JpaRepository<Gasto, Integer> {
    List<Gasto> findByValor(Double valor);
    
    List<Gasto> findByFecha(LocalDate fecha);
}
