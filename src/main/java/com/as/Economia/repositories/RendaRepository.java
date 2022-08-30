package com.as.Economia.repositories;

import com.as.Economia.entities.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RendaRepository extends JpaRepository<Renda, Long> {

}
