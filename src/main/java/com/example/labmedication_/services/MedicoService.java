package com.example.labmedication_.services;

import com.example.labmedication_.model.Medico;
import com.example.labmedication_.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private  MedicoRepository medicoRepository;

    public Medico cadastrarMedico(
            String nome,
            String genero,
            String dtNasccimento,
            String cpf,
            String rg,
            String  estadoCivil,
            String  telefone,
            String email,
            String naturalidade,
            String crm,
            String especializacao,
            String senha
    ){
        Medico medico = new Medico();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(cpf);
        medico.setNome(nome);
        medico.setGenero(genero);

        medico.setCpf(cpf);
        medico.setRg(rg);
        medico.setEstadoCivil(estadoCivil);
        medico.setTelefone(telefone);
        medico.setEmail(email);
        medico.setNaturalidade(naturalidade);

        medico.setCrm(crm);
        medico.setEspecializacaoClinica(especializacao);
        medico.setSenha(senha);

        Optional<List<Medico>> md = medicoRepository.findByCpf(cpf);




        if (!md.get().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"usuario já cadastrado");
        }

        try{
            medico.setDtNascimento(formato.parse(dtNasccimento));
            medicoRepository.save(medico);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        return medico;

    }
}
