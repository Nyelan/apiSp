package med.doll.api.medico;

public record DadosListagemMedicos(String nome, String email, String crm, Especialidades especialidade) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
