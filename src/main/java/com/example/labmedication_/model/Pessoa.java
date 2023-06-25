package com.example.labmedication_.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"cpf"})
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String genero;

    @Column(name = "DT_NASCIMENTO")
    @NotNull(message = "Data de nascimento não deve ser vazia")
    private Date dtNascimento;

    @NotNull(message = "Cpf não deve ser vazio")
    private String cpf;

    @NotNull(message = "Rg não deve ser vazio")
    private String rg;

    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;

    private String telefone;

    private String email;

    private String naturalidade;
}
