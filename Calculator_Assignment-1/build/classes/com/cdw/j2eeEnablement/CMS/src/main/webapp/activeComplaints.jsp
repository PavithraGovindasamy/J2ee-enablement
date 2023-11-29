<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.unique.Complaint" %>
<%@ page import="com.unique.DataBaseUtils" %>

<html>
<head>
    <title>Active Complaints</title>
</head>
<body>

<h1>Active Complaints</h1>

<%
    List<Complaint> activeComplaints = DataBaseUtils.getActiveComplaints();

    for (Complaint complaint : activeComplaints) {
%>
    <p>Complaint ID: <%= complaint.getUserName() %></p>
    <p>Description: <%= complaint.getComplaintText() %></p>
    <p>Status: <%= complaint.getStatus() %></p>
    <hr/>
<%
    }
%>
<form action="takeAction" method="post">
<button type="submit">Take Action</button>
</form>


    <form action="logout" method="get"> 
  
        <h2> 
            Hello 
            <%=request.getParameter("email")%>! 
        </h2> 
  
        <br> <input type="submit" value="Logout" /> 
    </form>

</body>
</html>
