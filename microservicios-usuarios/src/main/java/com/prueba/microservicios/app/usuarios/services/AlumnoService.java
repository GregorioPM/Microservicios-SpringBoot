package com.prueba.microservicios.app.usuarios.services;

import com.prueba.microservicios.app.usuarios.models.entity.Alumno;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AlumnoService {

    Iterable<Alumno> findAll();
    Alumno findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
    Alumno update(Long id,Alumno alumno);


}
