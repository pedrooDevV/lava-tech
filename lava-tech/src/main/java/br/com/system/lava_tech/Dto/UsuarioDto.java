package br.com.system.lava_tech.Dto;

import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Enum.Escala;

import java.math.BigDecimal;

public record UsuarioDto(
    String nome,
    String cpf,
    String telefone,
    String email,
    BigDecimal salario,
    String matricula,
    BigDecimal saldo,
    Escala escala,
    Perfil perfil
){}
