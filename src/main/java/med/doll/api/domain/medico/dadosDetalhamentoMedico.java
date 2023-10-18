package med.doll.api.domain.medico;

import med.doll.api.domain.endereco.Endereco;

public record dadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public dadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }


}
