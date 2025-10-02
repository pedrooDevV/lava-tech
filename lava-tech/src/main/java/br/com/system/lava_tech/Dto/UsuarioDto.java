package br.com.system.lava_tech.Dto;

import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Enum.Turno;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UsuarioDto(
    String nome,
    String cpf,
    String telefone,
    String email,
    BigDecimal salario,
    String matricula,
    BigDecimal saldo,
    Turno turno,
    Perfil perfil
){}
