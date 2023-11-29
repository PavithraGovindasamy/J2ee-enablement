<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Visit Tracking</title>
</head>
<body>
	<%
	// getting the name from the form and setting it
	String name = request.getParameter("name");
	session.setAttribute("userName", name);
	
	
	// adding the age to cookie
	Cookie ageCookie = new Cookie("age", request.getParameter("age"));
	response.addCookie(ageCookie);
	
	
	//retrieving the userName,userId from session
	String userNameInSession = (String) session.getAttribute("userName");
	String userID = (String) session.getAttribute("userID");
	
	// set for storing unique names of the user
	Set<String> uniqueNames = (Set<String>) session.getAttribute("uniqueNames");
	if (uniqueNames == null) {
		uniqueNames = new HashSet<>();
		session.setAttribute("uniqueNames", uniqueNames);
	} 
	// new user
	if (!uniqueNames.contains(userNameInSession)) {
		userID = UUID.randomUUID().toString();
		session.setAttribute("userID", userID);
		session.setAttribute("userName", name);
		out.println("Welcome, NEW USER!");
		uniqueNames.add(userNameInSession);
		// deleting cookies for new user entry
		
		 Cookie cookies[]=request.getCookies();
				
	    for(Cookie cookie: cookies){
	    	if(cookie.getName().equals("age")){
	    		out.println("OLD COOKIE"+ cookie.getValue());
	    		cookie.setMaxAge(0);
	    		cookie.setValue("");
	    		response.addCookie(cookie);
	    	}
	    }

	} else {
		out.println("Welcome Back,OLD USER "+userID);
	}

	%>
</body>
</html>
