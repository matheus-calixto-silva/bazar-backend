package com.matheus.calixto.bazarbackend.services;

import com.matheus.calixto.bazarbackend.models.entities.Lote;
import com.matheus.calixto.bazarbackend.models.repos.LoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class LoteService {
  @Autowired
  private LoteRepository loteRepository;
  
  public List<Lote> listAllLotes() {
    return loteRepository.findAll();
  }

  public void saveLote(Lote lote) {
    loteRepository.save(lote);
  }

  public Lote getLote(Integer id) {
    return loteRepository.findById(id).get();
  }

  public void deleteLote(Integer id) {
    loteRepository.deleteById(id);
  }
  
}