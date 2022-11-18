package com.examen.procesos.negocios.repository;


import com.examen.procesos.negocios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    List<Usuario> findAllByNombre(String nombre);
    List<Usuario> findAllByNombreAndApellidos(String nombre, String apellidos);
    List<Usuario> findAllByApellidos(String apellidos);

    Usuario findByCorreo(String correo);

}
