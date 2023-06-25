package com.example.labmedication_.repository;

import com.example.labmedication_.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface medicoReprository extends JpaRepository<Medico,Integer> {
}
