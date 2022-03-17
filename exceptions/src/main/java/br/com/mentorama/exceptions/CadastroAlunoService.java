package br.com.mentorama.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CadastroAlunoService extends CadastroAluno {

    public final List<CadastroAluno> cadastros;

    public CadastroAlunoService(Integer id, String nome, Integer idade) {
        super(id, nome, idade);

        this.cadastros = new ArrayList<>();

        CadastroAluno aluno1 = new CadastroAluno(01, "André", 19);
        CadastroAluno aluno2 = new CadastroAluno(02, "Bruna", 18);
        CadastroAluno aluno3 = new CadastroAluno(03, "Carlos", 21);
        CadastroAluno aluno4 = new CadastroAluno(04, "Bruna", 21);
        CadastroAluno aluno5 = new CadastroAluno(05, "Diana", 21);

        this.cadastros.add(aluno1);
        this.cadastros.add(aluno2);
        this.cadastros.add(aluno3);
        this.cadastros.add(aluno4);
        this.cadastros.add(aluno5);
    }


    // 1.1) Listar todos:

    public List<CadastroAluno> findAll() {
        return cadastros;

    }

    // 1.2) Filtar por nome:

    public List<CadastroAluno> listByName(String nome) {
        return cadastros.stream()
                .filter(cad -> cad.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    // 1.3) Filtar por idade:

    public List<CadastroAluno> listByIdade(Integer idade) {
        return cadastros.stream()
                .filter(cad -> cad.getIdade().equals(idade))
                .collect(Collectors.toList());
    }

    // 2) Buscar Aluno por Id:

    public CadastroAluno findById(Integer id) {
        return cadastros.stream()
                .filter(cad -> cad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 3) Cadastrar um Novo Aluno:

    public List<CadastroAluno> createCadastroAluno(CadastroAluno cadastroAluno) {
        if (cadastroAluno.getId() == null) {
            cadastroAluno.setId(cadastros.size() + 1);
        }
            cadastros.add(cadastroAluno);
            return cadastros;
    }

    // 4) Alterar a Idade no Cadastro de um Aluno:

    //public List<CadastroAluno> updateCadastroAluno(Integer id){
    //    cadastros.stream()
    //            .filter((cad-> cad.getId().equals(id)))
    //            .forEach(cad-> cad.setIdade(cadastroAluno.getIdade()));
    //
    //}

    // 5) Remover o Cadastro de um Aluno:

    //public List<CadastroAluno> deleteCadastroAluno(Integer id){
    //    cadastros.removeIf(cad -> cad.getId().equals(id));
    //}
}

