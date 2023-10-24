package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class consultaController {

    @Autowired
    private consultaRepository repository;

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

    @GetMapping
    public ResponseEntity<Page<dadosListagemConsultas>> listar(@PageableDefault(sort = {"data"})Pageable paginacao){
        var page = repository.findAllByMotivoCancelamentoIsNull(paginacao).map(dadosListagemConsultas::new);

        return ResponseEntity.ok(page);
    }

}
