package com.examen.procesos.negocios.repository;

import com.examen.procesos.negocios.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
    List<Articulo> findAllByCodigo(String codigo);
    Optional<Articulo> findByCodigo(String codigo);
}
