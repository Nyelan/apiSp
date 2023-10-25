package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.validacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

public class validadorHorarioAntecedencia {

    public void validar(dadosAgendamentosConsulta dados){
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new validacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência.");
        }
    }

}
