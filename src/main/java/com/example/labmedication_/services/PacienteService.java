package com.example.labmedication_.services;

import com.example.labmedication_.model.Endereco;
import com.example.labmedication_.model.Medico;
import com.example.labmedication_.model.Paciente;
import com.example.labmedication_.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    public Paciente cadastrarPaciente(
            String nome,
            String genero,
            String dtNasccimento,
            String cpf,
            String rg,
            String  estadoCivil,
            String  telefone,
            String email,
            String naturalidade,
            String contatoEmergencia,
            String listaAlergias,
            String listaCuidados,
            String convenio,
            String numeroCarteira,
            String validadeCarteira,
            Endereco endereco
    ){
        Paciente paciente = new Paciente();




        paciente.setNome(nome);
        paciente.setGenero(genero);

        paciente.setCpf(cpf);
        paciente.setRg(rg);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setNaturalidade(naturalidade);

        paciente.setContatoEmergencia(contatoEmergencia);
        paciente.setListaAlergias(listaAlergias);
        paciente.setListaCuidadosEspecificos(listaCuidados);
        paciente.setConvenio(convenio);
        paciente.setNumeroConvenio(numeroCarteira);


        paciente.setEndereco(endereco);



        Optional<List<Paciente>> pc = pacienteRepository.findByCpf(cpf);




        if (!pc.get().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"paciente já cadastrado");
        }

        try{
            paciente.setDtNascimento(formato.parse(dtNasccimento));

            if(validadeCarteira != null && validadeCarteira != ""){
                paciente.setValidadeConvenio(formato.parse(validadeCarteira));
            }

            pacienteRepository.save(paciente);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        return paciente;
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
}
