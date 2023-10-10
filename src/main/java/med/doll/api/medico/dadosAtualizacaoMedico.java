package med.doll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.doll.api.endereco.dadosEndereco;

public record dadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        dadosEndereco endereco) {

}
