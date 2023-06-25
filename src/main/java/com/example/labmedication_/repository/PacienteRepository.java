package com.example.labmedication_.repository;

import com.example.labmedication_.model.Medico;
import com.example.labmedication_.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
