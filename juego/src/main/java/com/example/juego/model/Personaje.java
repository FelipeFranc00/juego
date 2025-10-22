package com.example.juego.model;

import java.util.List;


public class Personaje {

    private Integer id;
    private String nombre;
    private String tipo;
    private String descripcion;
    private int ataque;
    private int defensa;
    private int estamina;
    private List<Integer> habilidades;


    
    public Personaje(Integer id, String nombre, String tipo, String descripcion, int ataque, int defensa, int estamina,
            List<Integer> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ataque = ataque;
        this.defensa = defensa;
        this.estamina = estamina;
        this.habilidades = habilidades;
    }

    public Personaje() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public int getEstamina() {
        return estamina;
    }
    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }
    public List<Integer> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<Integer> habilidades) {
        this.habilidades = habilidades;
    }


// Getters, setters y constructor vacío

}
