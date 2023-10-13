package med.doll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.doll.api.domain.endereco.dadosEndereco;

public record dadosCadastroMedico(
        @NotBlank
        String nome,
        @NotNull
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidades especialidade,
        @NotNull
        @Valid
        dadosEndereco endereco) {
}
