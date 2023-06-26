package com.example.labmedication_.controller;

import com.example.labmedication_.services.MedicamentoService;
import com.example.labmedication_.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EstatiscasController {

    @Autowired
    private MedicamentoService medicacaoService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/estatisticas")
    public ResponseEntity<String> estaticar(){
        return new ResponseEntity<>(
                "Total de pacientes: "+ pacienteService.contagem()+" Medicações adimistradas: "+ medicacaoService.contagem() ,
                HttpStatus.OK);
    }
}
