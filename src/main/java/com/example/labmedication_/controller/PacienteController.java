package com.example.labmedication_.controller;

import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.model.Paciente;
import com.example.labmedication_.services.EnderecoService;
import com.example.labmedication_.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/paciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarPaciente(@RequestBody Map<String,String> userMap) throws Exception {

        try{

            Endereco endereco = enderecoService.novoEndereco(
                    userMap.get("cep"),
                    userMap.get("cidade"),
                    userMap.get("estado"),
                    userMap.get("logradouro"),
                    userMap.get("numero"),
                    userMap.get("complemento"),
                    userMap.get("bairro"),
                    userMap.get("pontoReferencia")
            );


            return  pacienteService.cadastrarPaciente(
                    userMap.get("nome"),
                    userMap.get("genero"),
                    userMap.get("dtNasccimento"),
                    userMap.get("cpf"),
                    userMap.get("rg"),
                    userMap.get("estadoCivil"),
                    userMap.get("telefone"),
                    userMap.get("email"),
                    userMap.get("naturalidade"),
                    userMap.get("contatoEmergencia"),
                    userMap.get("listaAlergias"),
                    userMap.get("listaCuidados"),
                    userMap.get("convenio"),
                    userMap.get("numeroCarteira"),
                    userMap.get("validadeCarteira"),
                    endereco
            );
        }catch (Exception e){
            throw e;
        }
    }


    @PutMapping("/paciente/{id}")
    public Paciente atualizarPaciente(@PathVariable("id") Integer id, @RequestBody Map<String,String> userMap) throws Exception {

        try{
            return  pacienteService.atualizarPaciente(
                    id,
                    userMap.get("nome"),
                    userMap.get("genero"),
                    userMap.get("dtNasccimento"),
                    userMap.get("cpf"),
                    userMap.get("rg"),
                    userMap.get("estadoCivil"),
                    userMap.get("telefone"),
                    userMap.get("email"),
                    userMap.get("naturalidade"),
                    userMap.get("contatoEmergencia"),
                    userMap.get("listaAlergias"),
                    userMap.get("listaCuidados"),
                    userMap.get("convenio"),
                    userMap.get("numeroCarteira"),
                    userMap.get("validadeCarteira")
            );
        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/paciente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable("id") Integer id) throws Exception {

        try{
            pacienteService.deletarPaciente(id);
        }catch (Exception e){
            throw e;
        }
    }
}
