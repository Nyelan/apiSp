package med.doll.api.controller;

import jakarta.validation.Valid;
import med.doll.api.domain.usuario.Usuario;
import med.doll.api.domain.usuario.dadosAutenticacao;
import med.doll.api.infra.security.dadosTokenJWT;
import med.doll.api.infra.security.tokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class autenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private tokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid dadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new dadosTokenJWT(tokenJWT));
    }

}
