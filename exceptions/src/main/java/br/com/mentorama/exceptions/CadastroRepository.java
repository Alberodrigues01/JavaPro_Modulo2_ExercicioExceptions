package br.com.mentorama.exceptions;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class CadastroRepository {

    private final List<CadastroAluno> cadastros;

    public CadastroRepository () {

        this.cadastros = new ArrayList<>();

        CadastroAluno aluno1 = new CadastroAluno(01 , "André", 19);
        CadastroAluno aluno2 = new CadastroAluno(02 , "Bruna", 18);
        CadastroAluno aluno3 = new CadastroAluno(03 , "Carlos",21);
        CadastroAluno aluno4 = new CadastroAluno(04 , "Bruna", 21);
        CadastroAluno aluno5 = new CadastroAluno(05 , "Diana", 21);

        cadastros.add(aluno1);
        cadastros.add(aluno2);
        cadastros.add(aluno3);
        cadastros.add(aluno4);
        cadastros.add(aluno5);
    }

   public List<CadastroAluno> findAll(){
        return cadastros;
   }

   //1.2) Filtrar por nome:
    public List<CadastroAluno> listByNome (String nome){
        return cadastros.stream()
                .filter(cad-> cad.getNome().contains(nome))
                .collect(Collectors.toList());
    }
    //1.3) Filtrar por nome:
    public List<CadastroAluno> listByIdade (Integer idade){
        return cadastros.stream()
                .filter(cad-> cad.getNome().equals(idade))
                .collect(Collectors.toList());
    }
    // 2) Buscar aluno por Id:
    public CadastroAluno findById (Integer id){
        return cadastros.stream()
                .filter(cad-> cad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void post(CadastroAluno cadastroAluno){
        this.cadastros.add(cadastroAluno);
    }
    public Integer count(){
        return cadastros.size();
    }

}
