package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.models.Articulo;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface ArticuloService {
    ResponseEntity <List<Articulo>> allArticles();
    ResponseEntity <Articulo> getArticleFindBycodige(String codigo);
    ResponseEntity <Articulo> createArticle( Articulo articulo);
    ResponseEntity <Articulo> deleteArticle(String codigo);
    ResponseEntity <Articulo> editArticle( String codigo, Articulo articulo);

}
