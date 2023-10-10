package med.doll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.doll.api.endereco.Endereco;
import med.doll.api.endereco.dadosEndereco;

public record dadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        dadosEndereco endereco) {
}
