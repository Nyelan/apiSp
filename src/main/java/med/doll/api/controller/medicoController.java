package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.endereco.Endereco;
import med.doll.api.medico.Medico;
import med.doll.api.medico.dadosCadastroMedico;
import med.doll.api.medico.medicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired
    private medicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid dadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
