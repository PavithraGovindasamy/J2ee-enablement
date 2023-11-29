<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cdw.j2eeEnablement.Calculator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body style='background-color: cyan'>
    <% Calculator calculator = new Calculator(); %>
    <p>RESULTS</p>
    The Result for Addition:<%= calculator.add(23, 34) %>
    <br> The Result for Subtraction:<%= calculator.subtract(23, 5) %>
    <br> The Result for Multiplication:<%= calculator.multiply(23, 5) %>
    <br>
    <%
    try {
        out.println("The Result for Division: " + calculator.divide(28, 23) );
    } catch (ArithmeticException e) {
        out.println("Cannot divide by zero");
    }
    %>
    <br>
</body>
</html>
