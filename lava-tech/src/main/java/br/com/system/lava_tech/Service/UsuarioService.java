package br.com.system.lava_tech.Service;

import br.com.system.lava_tech.Dto.UsuarioDto;
import br.com.system.lava_tech.Entity.Usuario;
import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Enum.TipoTrabalho;
import br.com.system.lava_tech.Exceptions.AtendenteException;
import br.com.system.lava_tech.Exceptions.PerfilException;
import br.com.system.lava_tech.Exceptions.UsuarioException;
import br.com.system.lava_tech.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void registrarUsuario(UsuarioDto usuarioDto) throws Throwable {

        if (usuarioRepository.existsByCpf(usuarioDto.cpf())) {
            throw new UsuarioException("Usuario já existe");
        }

        if (usuarioDto.perfil() == null) {
            throw new PerfilException();
        }

        Usuario usuario1 = new Usuario();

        usuario1.setPerfil(usuarioDto.perfil());
        usuario1.setEmail(usuarioDto.email());
        usuario1.setTelefone(usuarioDto.telefone());
        usuario1.setCpf(usuarioDto.cpf());
        usuario1.setNome(usuarioDto.nome());


        switch (usuarioDto.perfil()) {
            case CLIENTE -> {
                usuarioRepository.save(usuario1);
            }
            case ATENDENTE -> {
                usuario1.setMatricula(gerarMatricula());
                usuario1.setSalario(usuarioDto.salario());
                usuario1.setEscala(usuarioDto.escala());

                if (usuarioDto.perfil() == Perfil.ATENDENTE
                        && usuarioDto.escala() == null
                        || usuarioDto.salario() == null) {
                    throw new AtendenteException("Verifique o cadastro! Atendente deve ter um turno e salario. ");
                } else if (usuarioDto.salario().compareTo(BigDecimal.ZERO) == 0 || usuarioDto.salario().compareTo(new BigDecimal("1212.00")) < 0) {
                    throw new AtendenteException("Salario não pode ter o valor igual a 0 ou abaixo do salario minimo!");
                }

                usuarioRepository.save(usuario1);

            }


            default -> System.out.println("Tipo invalido, tipo existentes [ ATENDENTE ] e [ CLIENTE ]");

        }

    }


    public String gerarMatricula() {
        //Lenght maximo de matricula é 8

        final String CARACT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGIT = "123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < 2; i++) {
            stringBuilder.append(CARACT.charAt(random.nextInt(CARACT.length())));
        }
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(DIGIT.charAt(random.nextInt(DIGIT.length())));
        }
        stringBuilder.append(CARACT.charAt(random.nextInt(CARACT.length())));

        return stringBuilder.toString();
    }

}
