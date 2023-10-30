package med.doll.api.domain.consulta.validacoes.cancelamentos;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosCancelamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorConsultaJaCancelada implements validadorCancelamentoDeConsulta{

    @Autowired
    private consultaRepository repository;

    @Override
    public void validar(dadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        if(consulta.getMotivoCancelamento() != null){
            throw new validacaoException("Consulta já está cancelada pelo motivo: " + consulta.getMotivoCancelamento());
        }
    }
}
