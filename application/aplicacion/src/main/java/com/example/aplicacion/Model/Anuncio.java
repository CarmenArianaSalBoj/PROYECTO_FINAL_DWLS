/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.Model;

/**
 *
 * @author Ariana
 */
public class Anuncio {
    private String nombre;
    private String asunto;
    private String descripcion;
    
    //getters y setters
    public String getNombre(){
    return nombre;
    }
    public void setNombre(String nombre){
    this.nombre=nombre;
    }
    public String getAsunto(){
    return asunto;
    }
    public void setAsunto(String asunto){
    this.asunto=asunto;
    }
    public String getDescripcion(){
    return descripcion;
    }
    public void setDescripcion(String descripcion){
    this.descripcion=descripcion;
    }
    
}
