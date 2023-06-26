package com.example.labmedication_.services;


import com.example.labmedication_.model.*;
import com.example.labmedication_.repository.EnderecoRepository;
import com.example.labmedication_.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;


    public List<Medicamento> listar(){
        return  medicamentoRepository.findAll();
    }

    public Medicamento novaMedicacao(
            String nome,
            String tipo,
            String unidade,
            String obs,
            String paciente,
            String medico,
            String quantidade
    ){
        Medicamento medicamento = new Medicamento();

        medicamento.setNome(nome);
        medicamento.setObs(obs);



        try{
            medicamento.setTipo(TipoMedicamento.valueOf(tipo));
            medicamento.setUnidade(UnidadeMedicamento.valueOf(unidade));

            medicamento.setQuantidade(Float.parseFloat(quantidade));

            Paciente pc = pacienteService.buscar(Integer.parseInt(paciente));

            Medico md = medicoService.buscar(Integer.parseInt(medico));


            medicamento.setMedico(md);
            medicamento.setPaciente(pc);

            LocalDateTime now = LocalDateTime.now();

            medicamento.setDtAdministracao(now);

            medicamentoRepository.save(medicamento);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }


        return medicamento;
    }
}
