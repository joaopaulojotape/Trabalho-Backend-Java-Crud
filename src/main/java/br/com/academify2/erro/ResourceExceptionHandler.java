package br.com.academify2.erro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, ServletRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(), x.getDefaultMessage());

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

}