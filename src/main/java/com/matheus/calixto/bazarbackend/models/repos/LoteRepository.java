package com.matheus.calixto.bazarbackend.models.repos;

import com.matheus.calixto.bazarbackend.models.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<Lote, Integer>{
}