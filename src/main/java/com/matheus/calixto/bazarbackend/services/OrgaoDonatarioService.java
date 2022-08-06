package com.matheus.calixto.bazarbackend.services;

import com.matheus.calixto.bazarbackend.models.entities.OrgaoDonatario;
import com.matheus.calixto.bazarbackend.models.repos.OrgaoDonatarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class OrgaoDonatarioService {
  @Autowired
  private OrgaoDonatarioRepository orgaoDonatarioRepository;
  
  public List<OrgaoDonatario> listAllOrgaos() {
      return orgaoDonatarioRepository.findAll();
  }

  public void saveOrgaoDonatario(OrgaoDonatario orgaoFiscalizador) {
      orgaoDonatarioRepository.save(orgaoFiscalizador);
  }

  public OrgaoDonatario getOrgaoDonatario(Integer id) {
      return orgaoDonatarioRepository.findById(id).get();
  }

  public void deleteOrgaoDonatario(Integer id) {
      orgaoDonatarioRepository.deleteById(id);
  }

}