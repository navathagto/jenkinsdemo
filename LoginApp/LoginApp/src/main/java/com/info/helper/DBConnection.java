package com.info.helper;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
	
	static MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
	
	public static MongoDatabase getdatabase() {
		MongoDatabase database = null;
		try{
			database = mongoClient.getDatabase("logindb");	
		}catch(Exception e){
			System.out.println("Execption");
		}
		return database;		
	}
}
