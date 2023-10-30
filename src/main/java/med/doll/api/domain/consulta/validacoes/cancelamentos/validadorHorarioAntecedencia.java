package med.doll.api.domain.consulta.validacoes.cancelamentos;

import med.doll.api.domain.consulta.consultaRepository;
import med.doll.api.domain.consulta.dadosCancelamentoConsulta;
import med.doll.api.domain.validacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("validadorHorarioAntecedenciaCancelamento")
public class validadorHorarioAntecedencia implements validadorCancelamentoDeConsulta{


    @Autowired
    private consultaRepository repository;

    @Override
    public void validar(dadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if(diferencaEmHoras < 24){
            throw new validacaoException("Consulta só pode ser cancelada com no mínimo 24 horas de antecedência.");
        }
    }
}
