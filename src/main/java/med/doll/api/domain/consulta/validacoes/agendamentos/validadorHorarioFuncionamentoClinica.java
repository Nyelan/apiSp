package med.doll.api.domain.consulta.validacoes.agendamentos;

import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class validadorHorarioFuncionamentoClinica implements validadorAgendamentoDeConsulta {

    public void validar(dadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new validacaoException("Consulta fora do horário de funcionamento da clínica.");
        }
    }

}
