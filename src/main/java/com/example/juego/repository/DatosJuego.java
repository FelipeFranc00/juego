package com.example.juego.repository;

import com.example.juego.model.Habilidad;
import com.example.juego.model.Personaje;

import java.util.Arrays;
import java.util.List;

public class DatosJuego {


public static final List<Habilidad> HABILIDADES = Arrays.asList(

new Habilidad(1, "Espadazo",

"Un ataque poderoso con la espada.", 10, 0, -5),

new Habilidad(2, "Escudo de Hierro",

"Aumenta la defensa del guerrero.", 0, 15, -3)

// Se creativo y agrega más habilidades para tu actividad

);


public static final List<Personaje> PERSONAJES = Arrays.asList(

new Personaje(1, "Gagh-Ar", "guerrero",

"Un valiente luchador con gran fuerza física.",

80, 70, 60, Arrays.asList(1, 2)),

new Personaje(2, "Elyra", "maga",

"Hechicera con gran dominio de la energía mágica.",

65, 40, 90, Arrays.asList(2))

// Se creativo y agrega más habilidades para tu actividad

);

}
