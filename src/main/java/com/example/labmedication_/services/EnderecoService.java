package com.example.labmedication_.services;

import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco novoEndereco(
            String cep,
            String cidade,
            String estado,
            String logradouro,
            Integer numero,
            String complemento,
            String bairro,
            String pontoReferencia
    ){
        Endereco endereco = new Endereco();

        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setPontoReferencia(pontoReferencia);

        try{
            enderecoRepository.save(endereco);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }


        return endereco;
    }
}
