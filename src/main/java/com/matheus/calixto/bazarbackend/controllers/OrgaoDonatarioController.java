package com.matheus.calixto.bazarbackend.controllers;

import com.matheus.calixto.bazarbackend.models.entities.OrgaoDonatario;
import com.matheus.calixto.bazarbackend.services.OrgaoDonatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/orgaos/donatario")
public class OrgaoDonatarioController {
    @Autowired
    OrgaoDonatarioService orgaoDonatarioService;

    @GetMapping("")
    public List<OrgaoDonatario> list() {
        return orgaoDonatarioService.listAllOrgaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoDonatario> get(@PathVariable Integer id) {
        try {
            OrgaoDonatario orgao = orgaoDonatarioService.getOrgaoDonatario(id);
            return new ResponseEntity<OrgaoDonatario>(orgao, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrgaoDonatario>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody OrgaoDonatario orgao) {
        orgaoDonatarioService.saveOrgaoDonatario(orgao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody OrgaoDonatario orgao, @PathVariable Integer id) {
        try {
            OrgaoDonatario existOrgaoDonatario = orgaoDonatarioService.getOrgaoDonatario(id);
            orgao.setId(id);            
            orgaoDonatarioService.saveOrgaoDonatario(orgao);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orgaoDonatarioService.deleteOrgaoDonatario(id);
    }
}