package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.validacaoException;

public class validadorPacienteSemOutraConsultaNoDia {

    private consultaRepository repository;

    public void validar(dadosAgendamentosConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new validacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
