package br.com.mentorama.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CadastroAlunoService {



    @Autowired
    private CadastroRepository cadastroRepository;

    private CadastroAluno cadastroAluno;

    public List<CadastroAluno> findAll() {

        return cadastroRepository.findAll();
    }

    public List<CadastroAluno> listByName(String nome) {

        boolean retorno;
        if (cadastroRepository.listByNome(nome).isEmpty()) {
            throw new RegistroInexistenteException("Nome Inexistente" + nome);
        }else{
            return cadastroRepository.listByNome(nome);
        }

    }

    public CadastroAluno findById (Integer id){

        if(cadastroRepository.findById(id) == null){
            throw new RegistroInexistenteException("ID Inexistente: "+id);
        }
        return cadastroRepository.findById(id);

    }

    public Integer post(CadastroAluno cadastroAluno){
        if (cadastroAluno.getId() == null){
            cadastroAluno.setId(cadastroRepository.count()+1);
        }
        cadastroRepository.post(cadastroAluno);
        return cadastroAluno.getId();
    }
}
