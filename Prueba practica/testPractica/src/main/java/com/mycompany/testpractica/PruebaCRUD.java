package com.mycompany.testpractica;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.DBObject;
import com.mongodb.client.model.Filters;
import javax.management.remote.JMXConnectorFactory;

public class PruebaCRUD {
    public Connection connector;
    public BasicDBObject documento = new BasicDBObject();
    MongoClient mongo =null;
    
    public PruebaCRUD(){
        
    }
    
    public void consultarDB(){
        try {
            connector = new Connection(); //creamos un nuevo conector
            connector.createConnection(); // establecemos conexion
            
            DBCursor cursor = connector.getCollection().find();
            
                while (cursor.hasNext()) {
                    
                    System.out.println("\n"+cursor.next()+"\n");
                }
            connector.closeConnection();
        }catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    public DBObject convert(Persona persona){
        return new BasicDBObject("Nombre", persona.getNombre())
                         .append("Edad", persona.getEdad())
                         .append("Amgigos", persona.getAmigos());
    }
    
    public void addPersona(Persona persona){
        try {
            connector = new Connection(); //creamos un nuevo conector
            connector.createConnection(); // establecemos conexion
            connector.getCollection().insert(convert(persona));
            connector.closeConnection();
        }catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePersona(String nombre){
        try {
            connector = new Connection();
            connector.createConnection();
            documento.put("Nombre", nombre);
            connector.getCollection().remove(documento);
            connector.closeConnection();
        }catch (MongoException e) {
            e.printStackTrace();
        }
    }
   
    public void modifyPersona(String nombre, Persona persona){
        try {
            connector = new Connection();
            connector.createConnection();
            
            documento.put("Nombre", nombre);
            connector.getCollection().findAndModify(documento, convert(persona));
            
            connector.closeConnection();
        }catch (MongoException e) {
            e.printStackTrace();
        }
    }
    
}
