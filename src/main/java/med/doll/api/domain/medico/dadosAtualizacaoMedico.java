package med.doll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.doll.api.domain.endereco.dadosEndereco;

public record dadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        dadosEndereco endereco) {

}
