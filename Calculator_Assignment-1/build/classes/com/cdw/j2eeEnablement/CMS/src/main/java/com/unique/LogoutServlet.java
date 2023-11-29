package com.unique;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		System.out.println("Session before invalidate: " + request.getSession(false));

		request.getSession(false).invalidate();

		System.out.println("Session after invalidate: " + request.getSession(false));

		out.println("Thank you! You are successfully logged out.");
		out.close();
	}

}