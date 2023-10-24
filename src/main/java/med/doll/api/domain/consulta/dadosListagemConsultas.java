package med.doll.api.domain.consulta;

import med.doll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record dadosListagemConsultas(Long id, String nomeMedico, Especialidade especialidade, String nomePaciente, LocalDateTime data, motivoCancelamento motivoCancelamento) {

    public dadosListagemConsultas(Consulta consulta){
        this(consulta.getId(), consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade(), consulta.getPaciente().getNome(), consulta.getData(), consulta.getMotivoCancelamento());
    }

}
