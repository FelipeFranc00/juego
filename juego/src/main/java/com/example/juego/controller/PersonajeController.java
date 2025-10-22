package com.example.juego.controller;
import com.example.juego.model.Personaje;
import com.example.juego.repository.DatosJuego;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/personajes")

public class PersonajeController {

    private static final List<Personaje> personajesGuardados = new ArrayList<>();

    @GetMapping
    public List<Personaje> obtenerPersonajes(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String tipo) {

            List<Personaje> todosLosPersonajes = new ArrayList<>(DatosJuego.PERSONAJES);
            todosLosPersonajes.addAll(personajesGuardados);

            if (nombre != null) {
                return todosLosPersonajes.stream()
                .filter(p -> p.getNombre()
                .toLowerCase()
                .contains(nombre.toLowerCase()))
                .toList();
            }

            if (tipo != null) {
                return todosLosPersonajes.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .toList();
            }
        return todosLosPersonajes;

    }


    @GetMapping("/{id}")
    public Personaje obtenerPorId(@PathVariable Integer id) {

        return DatosJuego.PERSONAJES.stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElse(null);

    }

    @GetMapping("/buscar") 
        public List<Personaje> buscarPersonajesPorNombre(
        @RequestParam(required = true) String nombre) { 

        List<Personaje> todosLosPersonajes = new ArrayList<>(DatosJuego.PERSONAJES);
        todosLosPersonajes.addAll(personajesGuardados); 

        return todosLosPersonajes.stream()
            .filter(p -> p.getNombre()
            .toLowerCase()
            .contains(nombre.toLowerCase()))
            .toList();
    }

    @PostMapping
    public ResponseEntity<Personaje> crearPersonaje(@RequestBody Personaje nuevoPersonaje) {
            personajesGuardados.add(nuevoPersonaje);
            return new ResponseEntity<>(nuevoPersonaje, HttpStatus.CREATED);
        }



    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(
        @PathVariable Integer id,
        @RequestBody Personaje personajeActualizado) { 

        if (!id.equals(personajeActualizado.getId())) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }

   
        int indice = -1;

        for (int i = 0; i < personajesGuardados.size(); i++) {

        if (personajesGuardados.get(i).getId().equals(id)) { 
            indice = i;
            break;
            }
        }
        
        if (indice != -1) {
            personajesGuardados.set(indice, personajeActualizado);
            return new ResponseEntity<>(personajeActualizado, HttpStatus.OK);
        } 
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonaje(@PathVariable Integer id) {
        boolean eliminado = personajesGuardados.removeIf(personaje -> personaje.getId().equals(id));

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}


