package br.com.system.lava_tech.Service;

import br.com.system.lava_tech.Dto.UsuarioDto;
import br.com.system.lava_tech.Entity.Usuario;
import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Exceptions.PerfilException;
import br.com.system.lava_tech.Exceptions.UsuarioNaoExisteException;
import br.com.system.lava_tech.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void registrarUsuario(UsuarioDto usuarioDto) throws Throwable {




    }


}
