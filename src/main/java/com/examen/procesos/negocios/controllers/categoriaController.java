package com.examen.procesos.negocios.controllers;

import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class categoriaController {

    @Autowired
    private CategoriaRepository   categoriaRepository;

    @GetMapping("/categorias")
    public ResponseEntity listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(categorias, HttpStatus.OK);

    }
    @PostMapping("/categoria")
    public ResponseEntity crearProducto(@RequestBody Categoria categoria){
        try {
            categoriaRepository.save(categoria);
            return  new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }


}