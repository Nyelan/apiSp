package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.validacaoException;

import java.time.DayOfWeek;

public class validadorHorarioFuncionamentoClinica {

    public void validar(dadosAgendamentosConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new validacaoException("Consulta fora do horário de funcionamento da clínica.");
        }
    }

}
