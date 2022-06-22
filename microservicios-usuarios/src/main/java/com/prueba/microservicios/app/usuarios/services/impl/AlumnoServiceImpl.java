package com.prueba.microservicios.app.usuarios.services.impl;

import com.prueba.microservicios.app.usuarios.exception.UsuarioException;
import com.prueba.microservicios.app.usuarios.models.entity.Alumno;
import com.prueba.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.prueba.microservicios.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UsuarioException(HttpStatus.NOT_FOUND, "No se encontro el alumno"));
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Alumno alumno= this.findById(id);
        repository.deleteById(id);
    }

    @Override
    public Alumno update(Long id, Alumno alumno) {
        Alumno alumnoFind=findById(id);
        alumnoFind.setNombre(alumno.getNombre());
        alumnoFind.setApellido(alumno.getApellido());
        alumnoFind.setEmail(alumno.getEmail());
        return repository.save(alumnoFind);
    }
}
