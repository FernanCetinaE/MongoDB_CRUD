package com.mycompany.testpractica;

public class PruebaMain {
    public static void main(String[] args) {
        String [] setAmigos = {"Teo","Rodrigo"};
        Persona persona = new Persona("Pedro",27,setAmigos);
        
        PruebaCRUD crud = new PruebaCRUD();
        crud.consultarDB();
        
        crud.addPersona(persona);
        crud.consultarDB();
        
        String [] setAmigos2 = {"Sofia","Pedro"};
        Persona persona2 = new Persona("Juan",23,setAmigos2);
        
        crud.modifyPersona("Juan", persona2);
        crud.consultarDB();
        
        crud.deletePersona("Jose Carlos");
        crud.consultarDB();
    }
}
