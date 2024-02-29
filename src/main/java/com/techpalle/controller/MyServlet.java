package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.UserDao;
import com.techpalle.model.User;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		
		switch(path) {
		
		case "/add": userForm(request, response);
			break;
			
		case "/insert": insert(request, response);
			break;
			
		case "/delete" : delete(request, response);
			break;
			
		case "/edit": edit(request, response);
			break;
		
		case "/update": update(request, response);
			break;
		default: list(request,response);
			break;
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		User u=new User(id,name,email,city);
		UserDao.update(u);
		RequestDispatcher rd=request.getRequestDispatcher("list");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		User ub=UserDao.edit(id);
		request.setAttribute("list", ub);
		RequestDispatcher rd=request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		RequestDispatcher rd=request.getRequestDispatcher("list");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse responsed) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		User u=new User(name,email,city);
		UserDao.insert(u);
		
		RequestDispatcher rd=request.getRequestDispatcher("list");
		try {
			rd.forward(request, responsed);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void userForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList al=UserDao.display();
		request.setAttribute("display", al);
		RequestDispatcher rd=request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
