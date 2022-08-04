package com.matheus.calixto.bazarbackend.services;

import com.matheus.calixto.bazarbackend.models.entities.Produto;
import com.matheus.calixto.bazarbackend.models.repos.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class ProdutoService {
  @Autowired
  private ProdutoRepository ProdutoRepository;
  
  public List<Produto> listAllProdutos() {
      return ProdutoRepository.findAll();
  }

  public void saveProduto(Produto produto) {
      ProdutoRepository.save(produto);
  }

  public Produto getProduto(Integer id) {
      return ProdutoRepository.findById(id).get();
  }

  public void deleteProduto(Integer id) {
      ProdutoRepository.deleteById(id);
  }

}