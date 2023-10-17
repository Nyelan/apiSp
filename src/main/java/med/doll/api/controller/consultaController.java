package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.consulta.dadosDetalhamentoConsulta;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class consultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid dadosAgendamentosConsulta dados){
        System.out.println(dados);
        return ResponseEntity.ok(new dadosDetalhamentoConsulta(dados.idMedico(), dados.idPaciente(), dados.data()));
    }
}
