package com.unique;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Filter
 */
public class Filter implements jakarta.servlet.Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		PrintWriter out = response.getWriter();
		out.println("HEY i am filter ");
		String email = request.getParameter("email");
		if (!email.isEmpty()) {
			chain.doFilter(request, response);
		} else {
			out.println("HEY DONT GIVE THE EMPTY EMAIL");
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
