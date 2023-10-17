package med.doll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dadosAgendamentosConsulta(Long idMedico, @NotNull Long idPaciente, @NotNull @Future LocalDateTime data) {

}
