package br.com.system.lava_tech.Repository;

import br.com.system.lava_tech.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Boolean existsByCpf(String cpf);

    Optional<Usuario> findByCpf(String Cpf);

}
