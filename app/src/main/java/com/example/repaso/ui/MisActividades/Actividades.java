package com.example.repaso.ui.MisActividades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Actividades implements Serializable {
private String nombre;
private String detalle;

private LocalDate fecha;

private LocalTime hora;

private String lugar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Actividades(String nombre, String detalle, LocalDate fecha, LocalTime hora, String lugar) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }
}
