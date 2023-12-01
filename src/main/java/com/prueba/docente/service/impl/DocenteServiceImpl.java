package com.prueba.docente.service.impl;

import com.prueba.docente.entity.Docente;
import com.prueba.docente.repository.DocenteRepository;
import com.prueba.docente.service.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {
    private final DocenteRepository docenteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Docente> getAll() {
        return docenteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Docente getById(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(null);
    }

    @Override
    @Transactional
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    @Transactional
    public Docente update(Docente docente) {
        Docente docenteById = docenteRepository.findById(docente.getId())
                .orElseThrow(null);
        docenteById.setNombre(docente.getNombre());
        docenteById.setDni(docente.getDni());
        docenteById.setFechaNacimiento(docente.getFechaNacimiento());
        docenteById.setSueldo(docente.getSueldo());
        docenteById.setEmail(docente.getEmail());
        docenteById.setSexo(docente.getSexo());
        docenteById.setCategoria(docente.getCategoria());
        return docenteRepository.save(docenteById);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        docenteRepository.deleteById(id);
        return true;
    }
}
