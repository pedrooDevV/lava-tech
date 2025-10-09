package br.com.system.lava_tech.Service;


import br.com.system.lava_tech.Dto.AgendamentoDto;
import br.com.system.lava_tech.Dto.AgendamentoResponse;
import br.com.system.lava_tech.Entity.Agendamento;
import br.com.system.lava_tech.Entity.Usuario;
import br.com.system.lava_tech.Enum.Perfil;
import br.com.system.lava_tech.Exceptions.UsuarioException;
import br.com.system.lava_tech.Repository.AgendaRepository;
import br.com.system.lava_tech.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void registraAgenda(AgendamentoDto agendamentoDto) {

        Usuario id = usuarioRepository.findByCpf(agendamentoDto.cpf())
                .orElseThrow(() -> new UsuarioException("Id não encontrado ao vincular com agenda ao usuario"));

        if (id.getPerfil() == Perfil.ATENDENTE) {
            throw new UsuarioException("Atendente não pode agendar");
        }

        Agendamento agendamento = new Agendamento();

        agendamento.setData(agendamentoDto.data());
        agendamento.setHora(agendamentoDto.hora());
        agendamento.setUsuario_id(id);
        agendamento.setTipoTrabalho(agendamentoDto.tipoTrabalho());


        System.out.println("Agendamento feito!");
        agendaRepository.save(agendamento);


    }

//    public AgendamentoResponse responseAgenda(Agendamento a) {
//        return new AgendamentoResponse(
//                a.getTipoTrabalho(),
//                a.getData(),
//                a.getHora()
//        );

    }



