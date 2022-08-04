package com.matheus.calixto.bazarbackend.controllers;

import com.matheus.calixto.bazarbackend.models.entities.Produto;
import com.matheus.calixto.bazarbackend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("")
    public List<Produto> list() {
        return produtoService.listAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> get(@PathVariable Integer id) {
        try {
            Produto produto = produtoService.getProduto(id);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody Produto produto) {
        produtoService.saveProduto(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Produto produto, @PathVariable Integer id) {
        try {
            Produto existProduto = produtoService.getProduto(id);
            produto.setId(id);            
            produtoService.saveProduto(produto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
    }
}