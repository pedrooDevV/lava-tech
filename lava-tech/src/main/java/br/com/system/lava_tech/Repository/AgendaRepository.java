package br.com.system.lava_tech.Repository;

import br.com.system.lava_tech.Entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agendamento, Long> {

    @Query("""
                SELECT a
                FROM Agendamento a
                JOIN a.usuario_id u
                WHERE u.nome = COALESCE(:nome, u.nome)
                  AND a.data = COALESCE(:data, a.data)
            """)
    List<Agendamento> buscaAgendamento(@Param("nome") String nome,
                                       @Param("data") LocalDate data);


}
