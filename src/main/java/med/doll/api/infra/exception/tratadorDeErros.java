package med.doll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import med.doll.api.domain.validacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class tratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(dadosErrorValidacao::new).toList());
    }

    @ExceptionHandler(validacaoException.class)
    public ResponseEntity tratarErroRegraDeNegocio(validacaoException ex){

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record dadosErrorValidacao(String campo, String msg){

        public dadosErrorValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }


}
