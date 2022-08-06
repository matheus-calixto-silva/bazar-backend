package com.matheus.calixto.bazarbackend.controllers;

import com.matheus.calixto.bazarbackend.models.entities.OrgaoFiscalizador;
import com.matheus.calixto.bazarbackend.services.OrgaoFiscalizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/orgaos/fiscalizador")
public class OrgaoFiscalizadorController {
    @Autowired
    OrgaoFiscalizadorService orgaoFiscalizadorService;

    @GetMapping("")
    public List<OrgaoFiscalizador> list() {
        return orgaoFiscalizadorService.listAllOrgaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoFiscalizador> get(@PathVariable Integer id) {
        try {
            OrgaoFiscalizador orgao = orgaoFiscalizadorService.getOrgaoFiscalizador(id);
            return new ResponseEntity<OrgaoFiscalizador>(orgao, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrgaoFiscalizador>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody OrgaoFiscalizador orgao) {
        orgaoFiscalizadorService.saveOrgaoFiscalizador(orgao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody OrgaoFiscalizador orgao, @PathVariable Integer id) {
        try {
            OrgaoFiscalizador existOrgaoFiscalizador = orgaoFiscalizadorService.getOrgaoFiscalizador(id);
            orgao.setId(id);            
            orgaoFiscalizadorService.saveOrgaoFiscalizador(orgao);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orgaoFiscalizadorService.deleteOrgaoFiscalizador(id);
    }
}