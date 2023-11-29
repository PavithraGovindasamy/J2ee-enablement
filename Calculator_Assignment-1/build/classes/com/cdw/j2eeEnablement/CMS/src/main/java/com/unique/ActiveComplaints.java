package com.unique;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActiveComplaints extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Complaint> activeComplaints = DataBaseUtils.getActiveComplaints();
		PrintWriter out = response.getWriter();

		out.print(activeComplaints);
		request.getRequestDispatcher("activeComplaints.jsp").forward(request, response);

	}

}
