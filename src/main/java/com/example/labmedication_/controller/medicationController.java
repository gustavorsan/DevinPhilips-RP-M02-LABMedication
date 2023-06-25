package com.example.labmedication_.controller;

import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.model.Medico;
import com.example.labmedication_.model.Paciente;
import com.example.labmedication_.services.EnderecoService;
import com.example.labmedication_.services.MedicoService;
import com.example.labmedication_.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/api")
public class medicationController {
    @Autowired
    private MedicoService medicoService;


    @Autowired
    private PacienteService pacienteService;


    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/usuario")
    public Medico cadastrarUsuario(@RequestBody Map<String,String> userMap) throws Exception {

        try{
          return  medicoService.cadastrarMedico(
                    userMap.get("nome"),
                    userMap.get("genero"),
                    userMap.get("dtNasccimento"),
                    userMap.get("cpf"),
                    userMap.get("rg"),
                    userMap.get("estadoCivil"),
                    userMap.get("telefone"),
                    userMap.get("email"),
                    userMap.get("naturalidade"),
                    userMap.get("crm"),
                    userMap.get("especializacao"),
                    userMap.get("senha")
            );
        }catch (Exception e){
            throw e;
         }
    }


    @PutMapping ("/usuario/{id}")
    public Medico atualizarUsuario(@PathVariable("id") Integer id,@RequestBody Map<String,String> userMap) throws Exception {

        try{
            return  medicoService.atualizarMedico(
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
                    userMap.get("crm"),
                    userMap.get("especializacao")
            );
        }catch (Exception e){
            throw e;
        }
    }


    @PutMapping ("/usuario/{id}/senha")
    public Medico atualizarSenhaUsuario(@PathVariable("id") Integer id,@RequestBody Map<String,String> userMap) throws Exception {

        try{
            return  medicoService.atualizarSenhaMedico(
                    id,
                    userMap.get("senha")
            );
        }catch (Exception e){
            throw e;
        }
    }


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



    @PutMapping ("/usuario/{id}")
    public Paciente atualizarPaciente(@PathVariable("id") Integer id,@RequestBody Map<String,String> userMap) throws Exception {

        try{
            return  pacienteService.atualizarMedico(
                    id,
                    userMap.get("nome"),
                    userMap.get("genero"),
                    userMap.get("dtNasccimento"),
                    userMap.get("cpf"),
                    userMap.get("rg"),
                    userMap.get("estadoCivil"),
                    userMap.get("telefone"),
                    userMap.get("email"),
                    userMap.get("naturalidade")
            );
        }catch (Exception e){
            throw e;
        }
    }
}
