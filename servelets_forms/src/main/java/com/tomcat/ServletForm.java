package com.tomcat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletForm")
public class ServletForm  extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Gson gson = new Gson();
		JsonObject formData = new JsonObject();
		res.setContentType("application/json");

		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (!paramName.equals("submit")) {
				String paramValue = (String) req.getParameter(paramName);
				formData.add(paramName, new Gson().toJsonTree(paramValue));
			}

		}
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");

		PrintWriter out = res.getWriter();
		String employeeId = "EMP" + (int) (Math.random() * 1000);
		formData.add("employeeId", new Gson().toJsonTree(employeeId));

		try (FileWriter file = new FileWriter("data.json", true)) {
			String path = new File(".").getCanonicalPath();
			System.out.println("[]" + path);
			file.write("," + formData.toString());
			file.flush();
			out.println("Data appended to JSON file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			out.println("Error appending to JSON file: " + e.getMessage());
		}

		
	}

}
