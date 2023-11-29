package com.tomcat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jdbcUrl = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "pavi0902";

		String sqlQuery = "SELECT * FROM employee";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = preparedStatement.executeQuery();

			PrintWriter out = response.getWriter();
            out.println("database data");
			while (resultSet.next()) {
				String columnName = resultSet.getString("name");

				out.println("Data from the database: " + columnName);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
