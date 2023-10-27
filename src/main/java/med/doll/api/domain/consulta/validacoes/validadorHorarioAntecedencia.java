package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class validadorHorarioAntecedencia implements validadorAgendamentoDeConsulta {

    public void validar(dadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new validacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência.");
        }
    }

}
