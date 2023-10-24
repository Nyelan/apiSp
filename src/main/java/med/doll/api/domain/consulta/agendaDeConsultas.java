package med.doll.api.domain.consulta;

import med.doll.api.domain.medico.Medico;
import med.doll.api.domain.medico.medicoRepository;
import med.doll.api.domain.paciente.pacienteRepository;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class agendaDeConsultas {

    @Autowired
    private consultaRepository consultaRepository;

    @Autowired
    medicoRepository medicoRepository;

    @Autowired
    pacienteRepository pacienteRepository;

    public void agendar(dadosAgendamentosConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new validacaoException("ID do paciente informado não existe.");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new validacaoException("ID do médico informado não existe.");
        }

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);

    }

    private Medico escolherMedico(dadosAgendamentosConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new validacaoException("Especialidade é obrigatória quando médico não for escolhido.");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(dadosCancelamentoConsulta dados) {
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new validacaoException("Consulta não encontrada");
        }
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
