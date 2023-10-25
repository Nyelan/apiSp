package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.medico.medicoRepository;
import med.doll.api.domain.validacaoException;

public class validadorMedicoAtivo {

    private medicoRepository repository;

    public void validar(dadosAgendamentosConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo){
            throw new validacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }

}
