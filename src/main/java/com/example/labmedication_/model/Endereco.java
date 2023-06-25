package com.example.labmedication_.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "o cep não deve ser vazio")
    private String cep;
    @NotNull(message = "o cidade não deve ser vazio")
    private String cidade;
    @NotNull(message = "o estado não deve ser vazio")
    private String estado;
    @NotNull(message = "o logradouro não deve ser vazio")
    private String logradouro;

    @NotNull(message = "o numero não deve ser vazio")
    private Integer numero;

    private String complemento;

    @NotNull(message = "o bairro não deve ser vazio")
    private  String bairro;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;
}
