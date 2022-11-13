package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.models.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {
    ResponseEntity<Categoria> createCategory(Categoria categoria);
    ResponseEntity<List<Categoria>>allCategory();
}
