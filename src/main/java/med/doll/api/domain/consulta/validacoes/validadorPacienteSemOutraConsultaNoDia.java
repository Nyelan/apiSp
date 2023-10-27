package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorPacienteSemOutraConsultaNoDia implements validadorAgendamentoDeConsulta {

    @Autowired
    private consultaRepository repository;

    public void validar(dadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new validacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
