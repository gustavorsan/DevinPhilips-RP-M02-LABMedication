package com.example.labmedication_.services;

import com.example.labmedication_.model.Medico;
import com.example.labmedication_.model.Paciente;
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
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


    public Medico buscar(Integer id){
        Optional<Medico> medico = medicoRepository.findById(id);

        if(medico.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }


        return medico.get();
    }

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

    public Medico atualizarMedico(
            int id,
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
            String especializacao
    ){
        Optional<Medico> medico = medicoRepository.findById(id);

        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }

        if (medico.get().getCpf() != cpf){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"cpf não deve ser alterado");
        }

        if (medico.get().getRg() != rg){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"rg não deve ser alterado");
        }

        if(medico.get().getNome() != nome){
            medico.get().setNome(nome);
        }

        if(medico.get().getGenero() != genero){
            medico.get().setGenero(genero);
        }

        if(medico.get().getEstadoCivil() != estadoCivil){
            medico.get().setEstadoCivil(estadoCivil);
        }

        if(medico.get().getTelefone() != telefone){
            medico.get().setTelefone(telefone);
        }

        if(medico.get().getEmail() != email){
            medico.get().setEmail(email);
        }

        if(medico.get().getNaturalidade() != naturalidade){
            medico.get().setNaturalidade(naturalidade);
        }

        if(medico.get().getCrm() != crm){
            medico.get().setCrm(crm);
        }

        if(medico.get().getEspecializacaoClinica() != especializacao){
            medico.get().setEspecializacaoClinica(especializacao);
        }



        try{

            medico.get().setDtNascimento(formato.parse(dtNasccimento));

            medicoRepository.save(medico.get());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        return medico.get();
    }

    public Medico atualizarSenhaMedico(
            int id,
            String senha
    ){
        Optional<Medico> medico = medicoRepository.findById(id);

        if (medico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }

        medico.get().setSenha(senha);



        try{

            medicoRepository.save(medico.get());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        return medico.get();
    }
}
