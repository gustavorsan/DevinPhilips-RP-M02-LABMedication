package com.example.labmedication_.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.random.RandomGenerator;

@Entity
@Data
public class Paciente extends Pessoa{
    @NotNull(message = "Contato de Emergencia não deve ser vazio")
    @Column(name = "contato_emergencia")
    private String contatoEmergencia;

    @Column(name = "lista_alergias")
    private String listaAlergias;

    @Column(name = "lista_cuidados")
    private String listaCuidadosEspecificos;

    private String convenio;

    @Column(name = "numero_convenio")
    private String numeroConvenio;

    @Column(name = "validade_convenio")
    private Date validadeConvenio;


    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
