package med.doll.api.domain.consulta.validacoes.agendamentos;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosAgendamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorMedicoComConsultaEmOutraData implements validadorAgendamentoDeConsulta {

    @Autowired
    private consultaRepository repository;

    public void validar(dadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new validacaoException("Médico possui outra consulta agendada nesse mesmo horário.");
        }

    }
}
