package com.demo.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;

public class ConnectionProvider {
 
	private static ConnectionProvider instance = null;
	private static MongoDatabase conn = null;
	
	private ConnectionProvider() {
		
	}
	
	static {
		try {
			//Class.forName(className);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static ConnectionProvider getInstance() {
		try {		
			synchronized (ConnectionProvider.class){
				if(instance == null) {
					instance = new ConnectionProvider();
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return instance;
	}
	
	public static MongoDatabase getDBConnection() {
		try {
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 

			// Creating Credentials 
			MongoCredential credential; 
			credential = MongoCredential.createCredential("admin", "employee","admin".toCharArray()); 
			System.out.println("Credentials ::"+ credential); 
			System.out.println("Connected to the database successfully");  
			
			// Accessing the database 
			conn = mongoClient.getDatabase("employee"); 
			System.out.println("Database is:"+ conn);
			 			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String args[]) {
		ConnectionProvider.getInstance().getDBConnection();
	}
}
