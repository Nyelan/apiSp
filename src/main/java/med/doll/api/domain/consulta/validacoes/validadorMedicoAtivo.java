package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.medico.medicoRepository;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorMedicoAtivo implements validadorAgendamentoDeConsulta {

    @Autowired
    private medicoRepository repository;

    public void validar(dadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo){
            throw new validacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }

}
