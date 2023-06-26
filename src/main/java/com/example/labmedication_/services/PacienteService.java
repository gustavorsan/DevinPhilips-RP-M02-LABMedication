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
    private  PacienteRepository pacienteRepository;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


    public List<Paciente> listar(){
        return  pacienteRepository.findAll();
    }

    public Paciente buscar(Integer id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if(paciente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }


        return paciente.get();
    }

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

    public Paciente atualizarPaciente(
            int id,
            String nome,
            String genero,
            String dtNasccimento,
            String cpf,
            String rg,
            String estadoCivil,
            String telefone,
            String email,
            String naturalidade,
            String contatoEmergencia,
            String listaAlergias,
            String listaCuidados,
            String convenio,
            String numeroCarteira,
            String validadeCarteira

    ){
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }

        if (paciente.get().getCpf() != cpf){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"cpf não deve ser alterado");
        }

        if (paciente.get().getRg() != rg){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"rg não deve ser alterado");
        }

        if(paciente.get().getNome() != nome){
            paciente.get().setNome(nome);
        }

        if(paciente.get().getGenero() != genero){
            paciente.get().setGenero(genero);
        }

        if(paciente.get().getEstadoCivil() != estadoCivil){
            paciente.get().setEstadoCivil(estadoCivil);
        }

        if(paciente.get().getTelefone() != telefone){
            paciente.get().setTelefone(telefone);
        }

        if(paciente.get().getEmail() != email){
            paciente.get().setEmail(email);
        }

        if(paciente.get().getNaturalidade() != naturalidade){
            paciente.get().setNaturalidade(naturalidade);
        }

        if(paciente.get().getContatoEmergencia() != contatoEmergencia){
            paciente.get().setContatoEmergencia(contatoEmergencia);
        }

        if(paciente.get().getConvenio() != convenio){
            paciente.get().setConvenio(convenio);
        }

        if(paciente.get().getListaCuidadosEspecificos() != listaCuidados){
            paciente.get().setConvenio(listaCuidados);
        }


        if(paciente.get().getListaAlergias() != listaAlergias){
            paciente.get().setConvenio(listaAlergias);
        }

        if(paciente.get().getNumeroConvenio() != numeroCarteira){
            paciente.get().setConvenio(numeroCarteira);
        }

        try{

            paciente.get().setDtNascimento(formato.parse(dtNasccimento));

            if(validadeCarteira != null && validadeCarteira != ""){
                paciente.get().setValidadeConvenio(formato.parse(validadeCarteira));
            }

            pacienteRepository.save(paciente.get());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        return paciente.get();
    }

    public void deletarPaciente(
            int id
    ){
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado");
        }

        try{
            pacienteRepository.delete(paciente.get());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}
