package med.doll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.doll.api.domain.endereco.dadosEndereco;

public record dadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        dadosEndereco endereco) {
}
