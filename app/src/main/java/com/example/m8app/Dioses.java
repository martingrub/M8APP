package com.example.m8app;

public class Dioses {
    private String nombre;
    private String panteon;
    private String rol;
    private String daño;
    private String rango;

    public Dioses() {
    }

    public Dioses(String nombre, String panteon, String rol, String daño, String rango) {
        this.nombre = nombre;
        this.panteon = panteon;
        this.rol = rol;
        this.daño = daño;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPanteon() {
        return panteon;
    }

    public void setPanteon(String panteon) {
        this.panteon = panteon;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDaño() {
        return daño;
    }

    public void setDaño(String daño) {
        this.daño = daño;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }


}
