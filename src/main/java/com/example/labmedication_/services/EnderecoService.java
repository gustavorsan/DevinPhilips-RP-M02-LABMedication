package com.example.labmedication_.services;

import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.model.Paciente;
import com.example.labmedication_.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> listar(){
        return  enderecoRepository.findAll();
    }

    public Endereco novoEndereco(
            String cep,
            String cidade,
            String estado,
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String pontoReferencia
    ){
        Endereco endereco = new Endereco();

        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setLogradouro(logradouro);

        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setPontoReferencia(pontoReferencia);

        try{
            endereco.setNumero(Integer.parseInt(numero));
            enderecoRepository.save(endereco);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }


        return endereco;
    }
}
