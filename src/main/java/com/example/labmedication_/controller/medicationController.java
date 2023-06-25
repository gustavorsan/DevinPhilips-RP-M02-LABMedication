package com.example.labmedication_.controller;

import com.example.labmedication_.model.Medico;
import com.example.labmedication_.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/api")
public class medicationController {
    @Autowired
    private MedicoService medicoService;

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
}
