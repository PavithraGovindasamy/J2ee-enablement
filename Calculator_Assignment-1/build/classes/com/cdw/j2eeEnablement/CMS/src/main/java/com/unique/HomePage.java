package com.unique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {

	private String userName;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("HEY I AM HOMEPAGE");
		try {
			String complaints = request.getParameter("complaints");
			out.println("Complaints: " + complaints);

			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals("user"))
						userName = cookie.getValue();
				}
				out.println("WELCOME " + userName);
			}

			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(userName);

			if (matcher.matches() && complaints.length() > 20) {
				DataBaseUtils.insertComplaint(userName, complaints);
			} else {
				out.println("Invalid email format or complaint message should be long. You are not allowed to enter");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
