package br.com.system.lava_tech.Entity;

import br.com.system.lava_tech.IdGenerator.IdGerente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gerente_tb")
public class Gerente {

    @Id
    @GeneratedValue(generator = "IdGerente")
    @GenericGenerator(name = "IdGerente", type = IdGerente.class)
    private String id;

    @NotBlank
    private String cpf;

    @NotBlank
    private String nome;

}
