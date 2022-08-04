package com.matheus.calixto.bazarbackend.models.repos;

import com.matheus.calixto.bazarbackend.models.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}