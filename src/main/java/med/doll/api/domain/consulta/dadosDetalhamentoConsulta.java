package med.doll.api.domain.consulta;

import java.time.LocalDateTime;

public record dadosDetalhamentoConsulta(Long idMedico, Long idPaciente, LocalDateTime data) {
}
