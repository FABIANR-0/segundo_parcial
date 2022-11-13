package com.examen.procesos.negocios.repository;

import com.examen.procesos.negocios.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    List<Categoria> findAllByNombre(String nombre);

}