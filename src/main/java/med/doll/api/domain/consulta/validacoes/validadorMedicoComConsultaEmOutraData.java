package med.doll.api.domain.consulta.validacoes;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.validacaoException;

public class validadorMedicoComConsultaEmOutraData {

    private consultaRepository repository;

    public void validar(dadosAgendamentosConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new validacaoException("Médico possui outra consulta agendada nesse mesmo horário.");
        }

    }
}
