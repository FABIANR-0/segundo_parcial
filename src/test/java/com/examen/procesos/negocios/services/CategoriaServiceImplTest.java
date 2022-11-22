package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.models.Categoria;
import com.examen.procesos.negocios.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CategoriaServiceImplTest {

    @InjectMocks
    private CategoriaServiceImpl categoriaServiceImpl;

    @InjectMocks
    private Categoria categoria;

    @Mock
    private CategoriaRepository categoriaRepository;
    @Test
    void seDebeListarLasCategorias() {
        //Given
        Categoria categoria = new Categoria();
        categoria.setId_ctg(1l);
        categoria.setNombre("Aseo");
        categoria.setDescripcion("articulos para el aseo");

        //when
        when(categoriaRepository.findAll()).thenReturn(List.of(categoria));


        ResponseEntity<List<Categoria>> usuario1 = categoriaServiceImpl.allCategory();

        //then
        Assertions.assertNotNull(usuario1);
    }
    @Test
    void whenNoEncuentraNingunaCategoria() {
        Categoria categoria = null;

        //When
        when(categoriaRepository.findAll()).thenReturn(Collections.emptyList());

        List<Categoria> usuario1 = categoriaServiceImpl.allCategory().getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }


}