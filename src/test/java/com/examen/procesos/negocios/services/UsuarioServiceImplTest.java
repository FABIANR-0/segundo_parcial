package com.examen.procesos.negocios.services;

import com.examen.procesos.negocios.Data.FactoryUsuarioTestData;
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
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;
    @InjectMocks
    private Usuario usuario;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void seDebeGuardarUnUsuario() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        given(usuarioRepository.findById(usuario.getId())).willReturn(Optional.of(usuario));
        given(usuarioRepository.save(usuario)).willReturn(usuario);
        //When

        ResponseEntity<Usuario> userSave = usuarioServiceImpl.createUser(usuario);

        //Then
        Assertions.assertNotNull(userSave);
    }
    @Test
    void seDebeEncontrarUnUsuarioPorId() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();
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
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        //when
        when(usuarioRepository.findAllByNombre(anyString())).thenReturn(List.of(usuario));


        ResponseEntity<List<Usuario>> usuario1 = usuarioServiceImpl.allUsersByName(anyString());

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
    @Test
    void seDebeEncontrarLosUsuariosPorApellido() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        //when
        when(usuarioRepository.findAllByApellidos("rios")).thenReturn(List.of(usuario));


        ResponseEntity<List<Usuario>> usuario1 = usuarioServiceImpl.allUsersByLastName("rios");

        //then
        Assertions.assertNotNull(usuario1);
    }

    @Test
    void whenNoEncuentraUsuariosPorApellido() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findAllByApellidos("rios")).thenReturn(Collections.emptyList());

        List<Usuario> usuario1 = usuarioServiceImpl.allUsersByLastName("rios").getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }
    @Test
    void seDebeEncontrarLosUsuariosPorNombresyApellidos() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        //when
        when(usuarioRepository.findAllByNombreAndApellidos("pepe", "rios")).thenReturn(List.of(usuario));


        ResponseEntity<List<Usuario>> usuario1 = usuarioServiceImpl.allUsersByNameAndLastName("pepe", "rios");

        //then
        Assertions.assertNotNull(usuario1);
    }
    @Test
    void whenNoEncuentraUsuariosPorNombresyApellidos() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findAllByNombreAndApellidos("pepe", "rios")).thenReturn(Collections.emptyList());

        List<Usuario> usuario1 = usuarioServiceImpl.allUsersByNameAndLastName("pepe", "rios").getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }
    @Test
    void seDebeListarLosUsuarios() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        //when
        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));


        ResponseEntity<List<Usuario>> usuario1 = usuarioServiceImpl.allUsers();

        //then
        Assertions.assertNotNull(usuario1);
    }
    @Test
    void whenNoEncuentraNingunUsuario() {
        Usuario usuario = null;

        //When
        when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());

        List<Usuario> usuario1 = usuarioServiceImpl.allUsers().getBody();

        //Then
        Assertions.assertEquals(null, usuario1);

    }
    @Test
    void seDebeActualizarUnUsuario() {
        // Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();
        Usuario usuarioAct = FactoryUsuarioTestData.mockUsuarioAct();
        given(usuarioRepository.findById(usuario.getId())).willReturn(Optional.of(usuario));
        given(usuarioRepository.save(usuarioAct)).willReturn(usuarioAct);

        //when
        ResponseEntity<Usuario> userSave = usuarioServiceImpl.editUser(usuario.getId(), usuarioAct);

        //Then
        Assertions.assertNotNull(userSave);
    }
    @Test
    void seDebeEliminarUnUsuario() {
        //Given
        Usuario usuario = FactoryUsuarioTestData.mockUsuario();

        given(usuarioRepository.findById(anyLong())).willReturn(null);

        //when
        usuarioRepository.deleteById(anyLong());
        Optional<Usuario> userDelete = usuarioRepository.findById(anyLong());

        //Then
        assertThat(userDelete).isNull();
    }
}