package br.com.system.lava_tech.Dto;

import br.com.system.lava_tech.Enum.TipoTrabalho;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoDto
(
    String cpf,
    TipoTrabalho tipoTrabalho,
    LocalDate data,
    LocalTime hora
)
{}
