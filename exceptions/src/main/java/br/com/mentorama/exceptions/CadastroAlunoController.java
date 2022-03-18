package br.com.mentorama.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroAlunoController {

    CadastroAlunoService cadastroAlunoService;

    //Listar todos:
    @GetMapping
    public ResponseEntity<List<CadastroAluno>> findAll() {
       return new ResponseEntity<>(cadastroAlunoService.findAll(), HttpStatus.OK);

       //Aqui a Application informa:
        //java.lang.NullPointerException: Cannot invoke "br.com.mentorama.exceptions.CadastroAlunoService.findAll()" because "this.cadastroAlunoService" is null
        //at br.com.mentorama.exceptions.CadastroAlunoController.findAll(CadastroAlunoController.java:22) ~[classes/:na]

   }

    // Listar por Nome:
    @GetMapping("/{nome}")
    public ResponseEntity<List<CadastroAluno>> ListByName(@PathVariable("nome") String nome) {
        return new ResponseEntity<>(cadastroAlunoService.listByName(nome) , HttpStatus.OK);
    }
}
