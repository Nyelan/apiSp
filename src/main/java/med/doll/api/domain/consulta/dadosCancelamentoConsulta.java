package med.doll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record dadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        motivoCancelamento motivo
) {
}
