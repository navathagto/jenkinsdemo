package com.info.dao;

import org.bson.Document;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.info.model.Visitor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoginDAOTest {

	static MongoClient mongoClient;
	static MongoDatabase database;
	static Visitor visitor; 
	static LoginDAO ld;
	@BeforeClass
	public static void dataConnection()
	{
		mongoClient = new MongoClient("127.0.0.1", 27017);
		try{
			database = mongoClient.getDatabase("logindb");	
		}catch(Exception e){
			System.out.println("Execption");
		}
				
	}
	@Before
	public void create()
	{
		visitor =new Visitor();
		ld=new LoginDAO();
	}

	@Test
	public void testInsertUser() {
		
		
		visitor.setFirstname("abc");
		visitor.setLastname("xyz");
		visitor.setUsername("abc");
		visitor.setPassword("abc");
		visitor.setEmailId("abc@gmail.com");
		visitor.setDob("10/10/2000");
		visitor.setSex("M");
		visitor.setMobnumber("9876543210");
		
		ld.insertUser(visitor);
			
		//To check whether the user has been inserted properly
		MongoCollection<Document> Visitor = database.getCollection("Visitor");
		Boolean inserted=false;
		FindIterable<Document> iterDoc = Visitor.find();
		for (Document document1 : iterDoc) {

			if ("abc".equals(document1.get("username").toString())) {
					inserted=true;
				
			}
	}
		assert(inserted);
		
	}
	
	@Test
	public void testDeleteUser() {
	
		//set all details
		visitor.setFirstname("abc");
		visitor.setLastname("xyz");
		visitor.setUsername("abc");
		visitor.setPassword("abc");
		visitor.setEmailId("abc@gmail.com");
		visitor.setDob("10/10/2000");
		visitor.setSex("M");
		visitor.setMobnumber("9876543210");
		
		//delete from db
		ld.deleteUser(visitor);
		
		MongoCollection<Document> Visitor = database.getCollection("Visitor");
		Boolean deleted=true;
		FindIterable<Document> iterDoc = Visitor.find();
		
		//Iterate and check whether user has been deleted properly
			for (Document document1 : iterDoc) {

				if ("abc".equals(document1.get("username").toString())) {
						deleted=false;
						
				}
	}
		assert(deleted);
		
	}

}
