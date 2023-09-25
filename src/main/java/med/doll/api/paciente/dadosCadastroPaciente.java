package med.doll.api.paciente;

import med.doll.api.endereco.dadosEndereco;

public record dadosCadastroPaciente(String nome, String email, String telefone, String cpf, dadosEndereco endereco) {
}
