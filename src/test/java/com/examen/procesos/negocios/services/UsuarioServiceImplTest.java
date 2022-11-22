package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.models.Usuario;
import com.examen.procesos.negocios.repository.UsuarioRepository;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;
    @InjectMocks
    Usuario usuario;
    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    void seDebeEncontrarUnUsuarioPorId() {
        //Given
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("pepe");
        usuario.setApellidos("Rios");
        usuario.setFechaNacimiento(new Date(2004, 7, 14));
        usuario.setCorreo("pepe@gmail.com");
        usuario.setPassword("1234");
        usuario.setDireccion("kdx.010-310");
        usuario.setDocumento("1064836389");
        usuario.setTelefono("3144454761");
        //when
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));
        ResponseEntity<Usuario> usuario1 = usuarioServiceImpl.getUserById(anyLong());

        //then
        Assertions.assertNotNull(usuario1);
    }
    @Test
    void whenNoEncuentraUsuarioPorId() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.ofNullable(usuario));

        Usuario usuario1 = usuarioServiceImpl.getUserById(anyLong()).getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }
    @Test
    void seDebeEncontrarLosUsuariosPorNombre() {
        //Given
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("pepe");
        usuario.setApellidos("Rios");
        usuario.setFechaNacimiento(new Date(2004, 7, 14));
        usuario.setCorreo("pepe@gmail.com");
        usuario.setPassword("1234");
        usuario.setDireccion("kdx.010-310");
        usuario.setDocumento("1064836389");
        usuario.setTelefono("3144454761");

        //when
        when(usuarioRepository.findAllByNombre("pepe")).thenReturn(List.of(usuario));


        ResponseEntity<List<Usuario>> usuario1 = usuarioServiceImpl.allUsersByName("pepe");

        //then
        Assertions.assertNotNull(usuario1);
    }
    @Test
    void whenNoEncuentraUsuariosPorNombre() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findAllByNombre("pepe")).thenReturn(Collections.emptyList());

        List<Usuario> usuario1 = usuarioServiceImpl.allUsersByName("pepe").getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }
}