package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.paciente.Paciente;
import med.doll.api.paciente.dadosCadastroPaciente;
import med.doll.api.paciente.pacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
