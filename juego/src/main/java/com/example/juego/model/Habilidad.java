package com.example.juego.model;

public class Habilidad {

    private int id;
    private String nombre;
    private String descripcion;
    private int incrementoAtaque;
    private int incrementoDefensa;
    private int incrementoEstamina;

    
    
    public Habilidad(int id, String nombre, String descripcion, int incrementoAtaque, int incrementoDefensa,
            int incrementoEstamina) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incrementoAtaque = incrementoAtaque;
        this.incrementoDefensa = incrementoDefensa;
        this.incrementoEstamina = incrementoEstamina;
    }

    public Habilidad() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIncrementoAtaque() {
        return incrementoAtaque;
    }
    public void setIncrementoAtaque(int incrementoAtaque) {
        this.incrementoAtaque = incrementoAtaque;
    }
    public int getIncrementoDefensa() {
        return incrementoDefensa;
    }
    public void setIncrementoDefensa(int incrementoDefensa) {
        this.incrementoDefensa = incrementoDefensa;
    }
    public int getIncrementoEstamina() {
        return incrementoEstamina;
    }
    public void setIncrementoEstamina(int incrementoEstamina) {
        this.incrementoEstamina = incrementoEstamina;
    }


// Getters, setters y constructor vacío

}
