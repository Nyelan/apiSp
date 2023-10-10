package med.doll.api.medico;

import med.doll.api.endereco.Endereco;

public record dadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidades especialidade, Endereco endereco) {

    public dadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }


}
