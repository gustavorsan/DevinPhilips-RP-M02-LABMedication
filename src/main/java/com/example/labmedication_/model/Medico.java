package com.example.labmedication_.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Medico extends Pessoa{
    @NotNull(message = "crm não deve ser vazio")
    private String crm;

    @Column(name = "especializacao_clinica")
    private String especializacaoClinica;

    @Size(min = 8)
    @NotNull(message ="senha não deve ser vazia")
    private String senha;
}
