package com.example.labmedication_.repository;

import com.example.labmedication_.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento,Integer> {
}
