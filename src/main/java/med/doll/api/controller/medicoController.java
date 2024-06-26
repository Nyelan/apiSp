package med.doll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.doll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class medicoController {

    @Autowired
    private medicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid dadosCadastroMedico dados, UriComponentsBuilder uriBuilder){

        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new dadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<dadosListagemMedicos>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page =  repository.findAllByAtivoTrue(paginacao).map(dadosListagemMedicos::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new dadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid dadosAtualizacaoMedico dados){
         var medico = repository.getReferenceById(dados.id());
         medico.atualizarInformacoes(dados);

         return ResponseEntity.ok(new dadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

}