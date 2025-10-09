package br.com.system.lava_tech.Entity;

import br.com.system.lava_tech.Enum.TipoTrabalho;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamento_tb")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTrabalho tipoTrabalho;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;

}
