package com.prueba.docente.controller;

import com.prueba.docente.entity.Docente;
import com.prueba.docente.service.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DocenteController {
    private final DocenteService docenteService;

    @GetMapping("/")
    public ResponseEntity<List<Docente>> getAll() {
        return new ResponseEntity<>(docenteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(docenteService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Docente> update(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.update(docente), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(docenteService.delete(id), HttpStatus.OK);
    }

}
