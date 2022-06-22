package com.prueba.microservicios.app.usuarios.controller;

import com.prueba.microservicios.app.usuarios.models.entity.Alumno;
import com.prueba.microservicios.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping({"/",""})
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id,alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
