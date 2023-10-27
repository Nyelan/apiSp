package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.paciente.pacienteRepository;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorPacienteAtivo implements validadorAgendamentoDeConsulta {

    @Autowired
    private pacienteRepository repository;

    public void validar(dadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo){
            throw new validacaoException("Consulta não pode ser agendada com paciente excluído.");
        }
    }

}
