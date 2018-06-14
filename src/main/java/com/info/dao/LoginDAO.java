package com.info.dao;

import org.bson.Document;

import com.info.helper.DBConnection;
import com.info.model.Visitor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoginDAO {
	
	MongoDatabase database;
	
	public LoginDAO() {
		database = DBConnection.getdatabase();
		System.out.println();
	}
	
	public Document retrieveVIS(Visitor visitor) {
		MongoCollection<Document> Visitor = database.getCollection("Visitor");
		FindIterable<Document> iterDoc = Visitor.find();

		for (Document document2 : iterDoc) {

			if (visitor.getUsername().toString().equals(document2.get("username").toString())) {

				return document2;
			}

		}
		return null;

	}

	public boolean insertUser(Visitor visitor) {
		Document document = new Document("firstname", visitor.getFirstname()).append("lastname", visitor.getLastname())
				.append("username", visitor.getUsername()).append("password", visitor.getPassword())
				.append("mobnumber", visitor.getMobnumber()).append("emailId", visitor.getEmailId())
				.append("dob", visitor.getDob()).append("sex", visitor.getSex());

		MongoCollection<Document> Visitor = database.getCollection("Visitor");
		FindIterable<Document> iterDoc = Visitor.find();
		for (Document document2 : iterDoc) {
			if (visitor.getMobnumber().equals(document2.get("mobnumber"))) {
				return false;
			}
		}

		Visitor.insertOne(document);
		if (document != null) {
			return true;
		}

		return false;

	}

	public void deleteUser(Visitor visitor) {
		MongoCollection<Document> Visitor = database.getCollection("Visitor");
		FindIterable<Document> iterDoc = Visitor.find();
		for (Document document : iterDoc) {

			if (visitor.getUsername().toString().equals(document.get("username").toString())) {
					Visitor.deleteOne(document);
			}
		}
	}
}
