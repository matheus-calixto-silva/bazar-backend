package com.matheus.calixto.bazarbackend.services;

import com.matheus.calixto.bazarbackend.models.entities.OrgaoFiscalizador;
import com.matheus.calixto.bazarbackend.models.repos.OrgaoFiscalizadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class OrgaoFiscalizadorService {
  @Autowired
  private OrgaoFiscalizadorRepository orgaoFiscalizadorRepository;
  
  public List<OrgaoFiscalizador> listAllOrgaos() {
      return orgaoFiscalizadorRepository.findAll();
  }

  public void saveOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
      orgaoFiscalizadorRepository.save(orgaoFiscalizador);
  }

  public OrgaoFiscalizador getOrgaoFiscalizador(Integer id) {
      return orgaoFiscalizadorRepository.findById(id).get();
  }

  public void deleteOrgaoFiscalizador(Integer id) {
      orgaoFiscalizadorRepository.deleteById(id);
  }

}