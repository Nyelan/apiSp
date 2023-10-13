package med.doll.api.domain.paciente;

import med.doll.api.domain.endereco.Endereco;

public record dadosDetalhamentoPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public dadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }


}
