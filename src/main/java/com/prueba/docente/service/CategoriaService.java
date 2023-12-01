package com.prueba.docente.service;

import com.prueba.docente.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAll();

    Categoria getById(Long id);

    Categoria save(Categoria categoria);

    Categoria update(Categoria categoria);

    Boolean delete(Long id);
}
