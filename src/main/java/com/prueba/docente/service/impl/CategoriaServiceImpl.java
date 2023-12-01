package com.prueba.docente.service.impl;

import com.prueba.docente.entity.Categoria;
import com.prueba.docente.repository.CategoriaRepository;
import com.prueba.docente.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(null);
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public Categoria update(Categoria categoria) {
        Categoria categoriaById = categoriaRepository.findById(categoria.getId())
                .orElseThrow(null);
        categoriaById.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaById);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        categoriaRepository.deleteById(id);
        return true;
    }
}
