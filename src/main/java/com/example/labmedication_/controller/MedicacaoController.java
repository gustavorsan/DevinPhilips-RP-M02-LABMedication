package com.example.labmedication_.controller;

import com.example.labmedication_.model.Medicamento;
import com.example.labmedication_.services.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicacaoController {
    @Autowired
    private MedicamentoService medicacaoService;

    public Medicamento cadastrar(){}

    public Medicamento atualizar(){}

    public List<Medicamento> listar(){}

    public void exluit(){

    }
}
