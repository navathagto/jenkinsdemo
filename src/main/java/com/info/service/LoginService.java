package com.info.service;

import org.bson.Document;

import com.info.dao.LoginDAO;
import com.info.model.Visitor;

public class LoginService {
	
	LoginDAO loginDAO;
	
	public LoginService() {
		loginDAO = new LoginDAO();
	}
	
	public Visitor checkVisitor(Visitor visitor) {
		
		Document doc = loginDAO.retrieveVIS(visitor);
		Visitor vis = null;

		if (doc != null) {
			if (visitor.getPassword().toString().equals(doc.get("password").toString())) {
				vis = new Visitor();
				vis.setUsername((String) doc.get("username"));
				vis.setPassword((String) doc.get("password"));
				return vis;
			}
		}
		return vis;
	}

	public Boolean createVisitor(Visitor visitor) {

		Boolean flag = loginDAO.insertUser(visitor);
		return flag;
	}

	public void deleteUser(Visitor visitor) {
		loginDAO.deleteUser(visitor);
	}
}
