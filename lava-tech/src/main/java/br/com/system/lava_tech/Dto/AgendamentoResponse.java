package br.com.system.lava_tech.Dto;

import br.com.system.lava_tech.Enum.TipoTrabalho;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AgendamentoResponse {

    String nome;
    TipoTrabalho tipoTrabalho;
    LocalDate data;
    LocalTime hora;

    public AgendamentoResponse(String nome, TipoTrabalho tipoTrabalho, LocalDate data, LocalTime hora) {
        this.nome = nome;
        this.tipoTrabalho = tipoTrabalho;
        this.data = data;
        this.hora = hora;
    }
}
