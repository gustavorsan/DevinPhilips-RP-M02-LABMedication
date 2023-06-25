package com.example.labmedication_.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "nome do medicamento não deve ser vazio")
    private String nome;

    @NotNull
    @Column(name = "a hora de Administracao deve ser informada")
    private LocalDateTime dtAdministracao;
    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

    @NotNull(message = "a quantidade não deve ser vazia")
    private Float quantidade;
    @Enumerated(EnumType.STRING)
    private UnidadeMedicamento unidade;

    @NotNull(message = "a obsercação deve ser obrigatoria")
    private String obs;

    @Column(name = "Paciente_id")
    @ManyToOne
    @JoinColumn(name = "id")
    private Paciente paciente;

    @Column(name = "Medico_Id")
    @ManyToOne
    @JoinColumn(name = "id")
    private Medico medico;


}
