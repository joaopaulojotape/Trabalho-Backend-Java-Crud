package br.com.academify2.resource;
import br.com.academify2.controller.AlunoController;
import br.com.academify2.model.Aluno;
import br.com.academify2.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("get/{id}")
    public Aluno get(@PathVariable(value = "id") int id) {
        return alunoRepository.findById(id);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Aluno> incluir(@Valid @RequestBody Aluno aluno) {

        AlunoController alunoController = new AlunoController();
        if (alunoController.validarAluno(aluno)) {
            aluno = alunoRepository.save(aluno);
            return new ResponseEntity(aluno, HttpStatus.OK);
        } else {
            return new ResponseEntity("Nome do aluno é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/editar")
    public ResponseEntity<Aluno> editar(@Valid @RequestBody Aluno aluno) {
        AlunoController alunoController = new AlunoController();
        if (alunoController.validarAluno(aluno)) {
            aluno = alunoRepository.save(aluno);
            return new ResponseEntity(aluno, HttpStatus.OK);
        } else {

            return new ResponseEntity("Nome do aluno é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/remover")
    public Aluno remover(@RequestBody Aluno aluno) {
        alunoRepository.delete(aluno);
        return aluno;
    }

    @DeleteMapping("apagar/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getTotal")
    public int getTotal() {
        return alunoRepository.findAll().size();
    }

}
