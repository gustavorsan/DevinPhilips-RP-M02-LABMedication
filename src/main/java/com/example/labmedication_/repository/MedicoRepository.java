package com.example.labmedication_.repository;

import com.example.labmedication_.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
    Optional<List<Medico>> findByCpf(String cpf);
}
