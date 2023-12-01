package com.prueba.docente.service;

import com.prueba.docente.entity.Docente;

import java.util.List;

public interface DocenteService {
    List<Docente> getAll();

    Docente getById(Long id);

    Docente save(Docente docente);

    Docente update(Docente docente);

    Boolean delete(Long id);
}
