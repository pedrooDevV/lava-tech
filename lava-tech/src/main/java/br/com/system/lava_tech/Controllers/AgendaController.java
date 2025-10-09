package br.com.system.lava_tech.Controllers;


import br.com.system.lava_tech.Dto.AgendamentoDto;
import br.com.system.lava_tech.Dto.AgendamentoResponse;
import br.com.system.lava_tech.Entity.Agendamento;
import br.com.system.lava_tech.Exceptions.AgendamentoException;
import br.com.system.lava_tech.Repository.AgendaRepository;
import br.com.system.lava_tech.Service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private AgendaRepository agendaRepository;


    @PostMapping("/agendar")
    public ResponseEntity<Map<String, String>> agendar(@RequestBody AgendamentoDto agendamentoDto) {

        try {
            agendaService.registraAgenda(agendamentoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Created", "agendado com sucesso"));
        } catch (AgendamentoException a) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                    (Map.of("Error", "Não foi possivel agendar" + a.getMessage()));
        }

    }

    @GetMapping("/agendados")
    public ResponseEntity<List<AgendamentoResponse>> mostrarAgendados(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "data", required = false) LocalDate data) {



        List<Agendamento> filtragem = agendaRepository.buscaAgendamento(nome, data);

        List<AgendamentoResponse> responses = filtragem.stream()
                .map(a -> new AgendamentoResponse(
                        a.getUsuario_id().getNome(),
                        a.getTipoTrabalho(),
                        a.getData(),
                        a.getHora()
                )).toList();


        if (filtragem.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(responses);
    }

}



