package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImpl implements CategoriaService{

        @Autowired
        private CategoriaRepository categoriaRepository;

        //private JWTUtil jwtUtil;
    @Override
    public ResponseEntity<Categoria> createCategory(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return  new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Categoria>> allCategory() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(categorias, HttpStatus.OK);

    }
}


