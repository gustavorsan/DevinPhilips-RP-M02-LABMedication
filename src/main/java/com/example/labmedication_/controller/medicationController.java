package com.example.labmedication_.controller;

import com.example.labmedication_.model.Medico;
import com.example.labmedication_.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
}
