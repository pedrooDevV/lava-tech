package br.com.system.lava_tech.Controllers;


import br.com.system.lava_tech.Dto.UsuarioDto;
import br.com.system.lava_tech.Exceptions.PerfilException;
import br.com.system.lava_tech.Exceptions.UsuarioException;
import br.com.system.lava_tech.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Map<String,String>> registrar(@RequestBody UsuarioDto usuarioDto) throws Throwable {
      try {
          usuarioService.registrarUsuario(usuarioDto);
          return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                  "Message", "Usuario criado com sucesso"
          ));
      }catch (UsuarioException | PerfilException e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
             "Error", e.getMessage()
          ));
      }
    }


}
