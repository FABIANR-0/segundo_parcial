package com.examen.procesos.negocios.controllers;

import com.examen.procesos.negocios.models.Articulo;
import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.ArticuloRepository;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import com.examen.procesos.negocios.services.ArticuloService;
import com.examen.procesos.negocios.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class articuloController {

    @Autowired
    private ArticuloRepository articuloRepository;
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private JWTUtil jwtUtil;
    @GetMapping("/articulos")
    public ResponseEntity listarArticulos(@RequestHeader(value="Authorization") String token) {

        try{
            if(jwtUtil.getKey(token) != null) {
                return articuloService.allArticles();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }


    }

    @GetMapping("/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo,@RequestHeader(value="Authorization") String token) {
        try{
            if(jwtUtil.getKey(token) != null) {
                return articuloService.getArticleFindBycodige(codigo);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }



    }
    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo,@RequestHeader(value="Authorization") String token){

        try{
            if(jwtUtil.getKey(token) != null) {
                return articuloService.createArticle(articulo);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }

    }
    @DeleteMapping("/articulo/codigo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo,@RequestHeader(value="Authorization") String token){
        try{
            if(jwtUtil.getKey(token) != null) {
                return articuloService.deleteArticle(codigo);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }


    }
    @PutMapping("/articulo/{codigo}")
    public ResponseEntity editarArticulo(@PathVariable String codigo,@RequestBody Articulo articulo,@RequestHeader(value="Authorization") String token){
        try{
            if(jwtUtil.getKey(token) != null) {
                return articuloService.editArticle(codigo,articulo);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }



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
