package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.domain.consulta.agendaDeConsultas;
import med.doll.api.domain.consulta.dadosAgendamentosConsulta;
import med.doll.api.domain.consulta.dadosCancelamentoConsulta;
import med.doll.api.domain.consulta.dadosDetalhamentoConsulta;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class consultaController {

    @Autowired
    private agendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid dadosAgendamentosConsulta dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new dadosDetalhamentoConsulta(dados.idMedico(), dados.idPaciente(), dados.data()));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid dadosCancelamentoConsulta dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
