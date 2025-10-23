package com.example.juego.controller;

import com.example.juego.model.Habilidad;
import com.example.juego.repository.DatosJuego; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    private static final List<Habilidad> habilidadesGuardadas = new ArrayList<>();
    private static int nextId = 100;


    @GetMapping
    public List<Habilidad> obtenerHabilidades() {
        List<Habilidad> todas = new ArrayList<>(DatosJuego.HABILIDADES);
        todas.addAll(habilidadesGuardadas);
        return todas;
    }

    @GetMapping("/{id}")
    public Habilidad obtenerPorId(@PathVariable int id) {

    Optional<Habilidad> habilidadGuardada = habilidadesGuardadas.stream()
        .filter(h -> h.getId() == id)
        .findFirst();

    if (habilidadGuardada.isPresent()) {
        return habilidadGuardada.get();
    }

    Optional<Habilidad> habilidadInicial = DatosJuego.HABILIDADES.stream()
        .filter(h -> h.getId() == id)
        .findFirst();
    
    return habilidadInicial.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Habilidad> crearHabilidad(@RequestBody Habilidad nuevaHabilidad) {
        if (nuevaHabilidad.getId() == 0) {
            nuevaHabilidad.setId(nextId++);
        }
        
        habilidadesGuardadas.add(nuevaHabilidad);
        return new ResponseEntity<>(nuevaHabilidad, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Habilidad> actualizarHabilidad(
        @PathVariable int id, 
        @RequestBody Habilidad habilidadActualizada) {

        if (id != habilidadActualizada.getId()) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request
        }

        int indice = -1;
        for (int i = 0; i < habilidadesGuardadas.size(); i++) {
            if (habilidadesGuardadas.get(i).getId() == id) { 
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            habilidadesGuardadas.set(indice, habilidadActualizada);
            return new ResponseEntity<>(habilidadActualizada, HttpStatus.OK); // 200 OK
        } 
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
    }
}