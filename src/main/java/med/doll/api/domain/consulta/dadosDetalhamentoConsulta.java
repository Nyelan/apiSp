package med.doll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record dadosDetalhamentoConsulta(
        Long idMedico,
        Long idPaciente,
        LocalDateTime data) {
}
