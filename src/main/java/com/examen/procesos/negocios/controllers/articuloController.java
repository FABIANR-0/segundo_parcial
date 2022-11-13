package com.examen.procesos.negocios.controllers;

import com.examen.procesos.negocios.models.Articulo;
import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.ArticuloRepository;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import com.examen.procesos.negocios.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class articuloController {

    @Autowired
    private ArticuloRepository articuloRepository;
    private CategoriaRepository categoriaRepository;
    private ArticuloService articuloService;

    @GetMapping("/articulos")
    public ResponseEntity listarArticulos() {
        return articuloService.allArticles();
    }

    @GetMapping("/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo) {
        return articuloService.getArticleFindBycodige(codigo);

    }
    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        return articuloService.createArticle(articulo);
    }
    @DeleteMapping("/articulo/codigo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo){
        return articuloService.deleteArticle(codigo);
    }
    @PutMapping("/articulo/{codigo}")
    public ResponseEntity editarArticulo(@PathVariable String codigo,@RequestBody Articulo articulo){
        return articuloService.editArticle(codigo,articulo);
    }
}
