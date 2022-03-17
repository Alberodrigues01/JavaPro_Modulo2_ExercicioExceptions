package br.com.mentorama.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exceptions")
public class CadastroAlunoController {

   CadastroAlunoService cadastroAlunoService;

    // Listar todos:
    @GetMapping
    public ResponseEntity <List<CadastroAluno>> findAll(){
        return new ResponseEntity<>(cadastroAlunoService.cadastros);

    }

    // Listar por Nome:
    @GetMapping("{/nome}")
    public ResponseEntity <List<CadastroAluno>> ListByName(@PathVariable ("nome") String nome) {
        return new ResponseEntity<>(cadastroAlunoService.getNome(), HttpStatus.OK);
    }
}
