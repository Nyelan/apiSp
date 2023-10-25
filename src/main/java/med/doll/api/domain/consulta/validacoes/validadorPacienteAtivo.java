package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.paciente.pacienteRepository;
import med.doll.api.domain.validacaoException;

public class validadorPacienteAtivo {

    private pacienteRepository repository;

    public void validar(dadosAgendamentosConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo){
            throw new validacaoException("Consulta não pode ser agendada com paciente excluído.");
        }
    }

}
