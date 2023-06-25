package com.example.labmedication_.repository;


import com.example.labmedication_.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    Optional<List<Paciente>> findByCpf(String cpf);
}
