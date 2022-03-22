package br.com.mentorama.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")

public class CadastroAlunoController {

    @Autowired
    private CadastroAlunoService cadastroAlunoService;

    //Listar todos:
    @GetMapping
    public ResponseEntity<List<CadastroAluno>> findAll(){
        return new ResponseEntity<>(cadastroAlunoService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<CadastroAluno>>  ListByName(@PathVariable("nome") String nome) {
         return new ResponseEntity<>(cadastroAlunoService.listByName(nome),HttpStatus.OK);

    }
    @GetMapping("/{id}/")
    public ResponseEntity<CadastroAluno>  findById (@PathVariable("id") Integer id){
        return new ResponseEntity<>(cadastroAlunoService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody CadastroAluno cadastroAluno){
        Integer id = cadastroAlunoService.post(cadastroAluno);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @ExceptionHandler({RegistroInexistenteException.class})
    public ResponseEntity<String> handle(final RegistroInexistenteException e){
        return new ResponseEntity<>("Registro Inexistente", HttpStatus.NOT_FOUND);
    }
}
