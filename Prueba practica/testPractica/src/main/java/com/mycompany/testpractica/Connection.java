package com.mycompany.testpractica;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connection {
    MongoClient mongo =null;
    private DB database;
    private DBCollection collection;
    
    public MongoClient createConnection(){
        try {
            mongo = new MongoClient("localhost",27017);
            this.database = mongo.getDB("SeresVivos");//llama a la base de datos
            this.collection = database.getCollection("Personas");//llama a la "particion"
            System.out.println("Success Connection \n");
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return mongo;
    }
    
    public MongoClient getMongo(){
        return mongo;
    }
    
    public boolean closeConnection(){
        boolean flag = true;
        
        try {
            mongo.close();
            System.out.println("Closed Connection \n");
        } catch (MongoException e) {
            e.printStackTrace();
        }
        
        return flag;
    }

    public DBCollection getCollection() {
        return collection;
    }

    public DB getDatabase() {
        return database;
    }

}
