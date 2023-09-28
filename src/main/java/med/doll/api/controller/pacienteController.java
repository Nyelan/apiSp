package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.medico.DadosListagemMedicos;
import med.doll.api.paciente.DadosListagemPacientes;
import med.doll.api.paciente.Paciente;
import med.doll.api.paciente.dadosCadastroPaciente;
import med.doll.api.paciente.pacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {

    @Autowired
    private pacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid dadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);
    }



}
