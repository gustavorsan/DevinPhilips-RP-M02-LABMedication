package com.example.labmedication_.controller;


import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.model.Paciente;
import com.example.labmedication_.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/paciente")
    public List<Endereco> listarEndereco() throws Exception {

        try{
            return  enderecoService.listar();

        }catch (Exception e){
            throw e;
        }
    }
    @PostMapping("/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco cadastrarEndereco(@RequestBody Map<String,String> userMap) throws Exception {
        try{
            return  enderecoService.novoEndereco(
                    userMap.get("cep"),
                    userMap.get("cidade"),
                    userMap.get("estado"),
                    userMap.get("logradouro"),
                    userMap.get("numero"),
                    userMap.get("complemento"),
                    userMap.get("bairro"),
                    userMap.get("pontoReferencia")
            );
        }catch (Exception e){
            throw e;
        }
    }
}
