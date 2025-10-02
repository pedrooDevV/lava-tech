package br.com.system.lava_tech.Entity;


import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Enum.Turno;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "usuario_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Column(name = "cpf", unique = true)
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 13)
    private String telefone;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotNull
    @Digits(integer = 7, fraction = 2)
    private BigDecimal salario;

    @NotBlank
    @Column(unique = true)
    private String matricula;

    @NotNull
    @Digits(integer = 7, fraction = 2)
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;
}
