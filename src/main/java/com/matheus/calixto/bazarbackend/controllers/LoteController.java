package com.matheus.calixto.bazarbackend.controllers;

import com.matheus.calixto.bazarbackend.models.entities.Lote;
import com.matheus.calixto.bazarbackend.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {
    @Autowired
    LoteService loteService;

    @GetMapping("")
    public List<Lote> list() {
        return loteService.listAllLotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> get(@PathVariable Integer id) {
        try {
            Lote Lote = loteService.getLote(id);
            return new ResponseEntity<Lote>(Lote, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Lote>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody Lote Lote) {
        loteService.saveLote(Lote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loteService.deleteLote(id);
    }
}