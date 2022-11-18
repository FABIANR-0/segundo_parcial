package com.examen.procesos.negocios.controllers;

import com.examen.procesos.negocios.models.Articulo;
import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.ArticuloRepository;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import com.examen.procesos.negocios.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class articuloController {

    @Autowired
    private ArticuloRepository articuloRepository;
    private CategoriaRepository categoriaRepository;
    @Autowired
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
