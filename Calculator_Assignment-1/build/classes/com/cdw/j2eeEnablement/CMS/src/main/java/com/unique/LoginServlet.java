package com.unique;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader("datas.json"));
			System.out.print("object" + jsonElement);
			if (jsonElement.isJsonArray()) {
				JsonArray jsonArray = jsonElement.getAsJsonArray();

				for (JsonElement element : jsonArray) {
					JsonObject userObject = element.getAsJsonObject();
					String storedUsername = userObject.get("username").getAsString();
					String storedPassword = userObject.get("password").getAsString();
					String storedRole = userObject.get("role").getAsString();

					if (username.equals(storedUsername) && password.equals(storedPassword)) {

						Cookie cookie = new Cookie("user", username);
						response.addCookie(cookie);
						request.setAttribute("username", username);
						if (storedRole.equals("user")) {
							
							RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
							dispatcher.forward(request, response);
						} else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("activeComplaints");
							dispatcher.forward(request, response);

						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
