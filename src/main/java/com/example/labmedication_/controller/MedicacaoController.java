package com.example.labmedication_.controller;

import com.example.labmedication_.model.Medicamento;
import com.example.labmedication_.services.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MedicacaoController {
    @Autowired
    private MedicamentoService medicacaoService;

    @PostMapping("/medicamentos")
    public Medicamento cadastrar(@RequestBody Map<String,String> userMap) throws Exception{
        try{
            return  medicacaoService.cadastrar(
                    userMap.get("nome"),
                    userMap.get("tipo"),
                    userMap.get("unidade"),
                    userMap.get("obs"),
                    userMap.get("paciente"),
                    userMap.get("medico"),
                    userMap.get("quantidade")
            );
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/medicamentos/{id}")
    public Medicamento atualizar(@PathVariable("id") Integer id, @RequestBody Map<String,String> userMap) throws Exception{
        try{
            return  medicacaoService.atualizar(
                    id,
                    userMap.get("tipo"),
                    userMap.get("unidade"),
                    userMap.get("obs")
            );
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/medicamentos")
    public List<Medicamento> listar() throws Exception{
        try{
            return  medicacaoService.listar();
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/medicamentos/{id}")
    public void exluir(@PathVariable("id") Integer id){

    }
}
