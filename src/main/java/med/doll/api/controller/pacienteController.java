package med.doll.api.controller;

import med.doll.api.paciente.dadosCadastroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {

    @PostMapping
    public void cadastrar(@RequestBody dadosCadastroPaciente dados){
        System.out.println(dados);
    }
}
