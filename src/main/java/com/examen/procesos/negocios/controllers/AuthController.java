package com.examen.procesos.negocios.controllers;

import com.examen.procesos.negocios.models.Usuario;
import com.examen.procesos.negocios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(maxAge = 3600)
@RestController
public class AuthController {
        @Autowired
        private UsuarioService usuarioService;

        @PostMapping(value = "/auth/login")
        public ResponseEntity login(@RequestBody Usuario usuario){
            return  usuarioService.login(usuario.getCorreo(),usuario.getPassword());
}
    }

