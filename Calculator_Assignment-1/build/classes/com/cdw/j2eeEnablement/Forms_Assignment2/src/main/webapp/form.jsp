<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, org.json.simple.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forms</title>
</head>
<body>
    <h1>The data is stored</h1>
    <%
    JSONObject formData = new JSONObject();
    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
        String paramName = (String) paramNames.nextElement();
        if (!paramName.equals("submit")) {
            String paramValue = request.getParameter(paramName);
            formData.put(paramName, paramValue);
        }

    }
    String employeeId = "EMP" + (int) (Math.random() * 1000);
    formData.put("employeeId", employeeId);

    try (FileWriter file = new FileWriter("data.json", true)) {
        String path = new File(".").getCanonicalPath();
        file.write("," + formData.toJSONString()); 
        file.flush();
        out.println("Data appended to JSON file successfully.");
    } catch (IOException e) {
        e.printStackTrace();
        out.println("Error appending to JSON file: " + e.getMessage());
    }
    %>
</body>
</html>
