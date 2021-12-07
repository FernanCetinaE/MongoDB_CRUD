package com.mycompany.testpractica;

public class Persona {
    private String nombre;
    private int edad;
    private String [] amigos;
    
    public Persona(String nombre,int edad,String [] amigos){
        this.nombre = nombre;
        this.edad=edad;
        this.amigos=amigos;
    }

    public String[] getAmigos() {
        return amigos;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
}
