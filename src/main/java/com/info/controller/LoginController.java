package com.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Visitor;
import com.info.service.LoginService;

@Controller
public class LoginController {

	HttpSession session;
	LoginService loginService;
	
	public LoginController() {
		loginService = new LoginService();
	}

	@RequestMapping("/authenticate.htm")
	public ModelAndView checkVisitor(HttpServletRequest request) {

		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");

		Visitor visitor = new Visitor();

		visitor.setUsername(uname);
		visitor.setPassword(pwd);

		Visitor vis = new Visitor();
		vis = loginService.checkVisitor(visitor);

		ModelAndView mView = new ModelAndView();

		session = request.getSession();

		if (vis != null) {
			session.setAttribute("visitor", vis);
			mView.addObject("username",uname);
			mView.setViewName("Home.jsp");
		} else {
			mView.addObject("message", "Invalid credentials !!!");
			mView.setViewName("Login.jsp");
		}

		return mView;
	}

	@RequestMapping("/create.htm")
	public ModelAndView createVisitor(HttpServletRequest request) {

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		/*
		 * String uname = request.getParameter("username1"); String pwd =
		 * request.getParameter("password1");
		 */
		String mobile = request.getParameter("mobile");
		String emailId = request.getParameter("emailId");
		String dob = request.getParameter("dob");
		String sex = request.getParameter("sex");
		// int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

		String uname = fname;
		String pwd = fname;

		Visitor visitor = new Visitor();

		visitor.setFirstname(fname);
		visitor.setLastname(lname);
		visitor.setUsername(uname);
		visitor.setPassword(pwd);
		visitor.setMobnumber(mobile);
		visitor.setEmailId(emailId);
		visitor.setDob(dob);
		visitor.setSex(sex);
		// visitor.setIsAdmin(isAdmin);

		ModelAndView mView = new ModelAndView();
		Boolean flag = false;
		flag = loginService.createVisitor(visitor);

		if (flag == true) {
			mView.addObject("register", "Successfully Created the User!!! Please Login!!!");
			mView.addObject("username",uname);
			mView.addObject("password",pwd);
			mView.setViewName("Login.jsp");
		} else {
			mView.addObject("error", "User already Exists!!!");
			mView.setViewName("Register.jsp");
		}

		return mView;
	}
	@RequestMapping("/delete.htm")
	public ModelAndView deleteUser(HttpServletRequest request) {
		Visitor visitor = (Visitor) request.getSession(false).getAttribute("visitor");
		String username = visitor.getUsername();
		Visitor visitor2 = new Visitor();
		visitor2.setUsername(username);
		loginService.deleteUser(visitor);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("Login.jsp");
		mView.addObject("delete", "Successfully Deleted the User");
		return mView;
	}
}
