package com.example.Zent.configuracion;

import com.example.Zent.modelos.Categoria;
import com.example.Zent.modelos.utils.TipoCategoria;
import com.example.Zent.modelos.utils.TipoDeEstado;
import com.example.Zent.repository.ICategoriaRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CargaCategorias implements CommandLineRunner {

    private final ICategoriaRepo categoriaRepositorio;

    public CargaCategorias(ICategoriaRepo categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void run(String... args) {
           TipoCategoria[] nombres = {
            TipoCategoria.Alimentacion,
            TipoCategoria.Transporte,
            TipoCategoria.Entretenimiento,
            TipoCategoria.Educacion,
            TipoCategoria.Tecnologia,
            TipoCategoria.Hogar
           };


        String[] responsables = {"Juan Pérez", "María Gómez", "Carlos López", "Ana Torres", "Luis Ramírez"};
        String[] justificaciones = {"Necesidad básica", "Uso frecuente", "Obligatorio", "Prevención", "Ocio"};
        String[] descripciones = {"Gastos mensuales", "Costos diarios", "Inversión anual", "Chequeos médicos", "Diversión"};
        TipoDeEstado[] estados = {TipoDeEstado.Activo, TipoDeEstado.Inactivo};

        LocalDate fechaBase = LocalDate.of(2026, 1, 1);
        Random aleatorio = new Random(42);
        List<Categoria> listaCategorias = new ArrayList<>();

                for (int i = 0; i < 50; i++) {
            TipoCategoria nombre = nombres[aleatorio.nextInt(nombres.length)];
            String responsable = responsables[aleatorio.nextInt(responsables.length)];
            String justificacion = justificaciones[aleatorio.nextInt(justificaciones.length)];
            String descripcion = descripciones[aleatorio.nextInt(descripciones.length)];
            TipoDeEstado estado = estados[aleatorio.nextInt(estados.length)];
            LocalDate fechaCreacion = fechaBase.plusDays(aleatorio.nextInt(30));
            LocalDate fechaModificacion = fechaCreacion.plusDays(aleatorio.nextInt(15));
            Integer codigo = 1000 + i;

            listaCategorias.add(new Categoria(
                    null,
                    nombre,
                    fechaCreacion,
                    responsable,
                    justificacion,
                    descripcion,
                    estado,
                    fechaModificacion,
                    codigo,
                    null // lista de gastos inicialmente vacía
            ));
        }

        categoriaRepositorio.saveAll(listaCategorias);
    }

}
