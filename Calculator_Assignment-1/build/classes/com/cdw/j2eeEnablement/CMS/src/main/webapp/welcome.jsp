<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${requestScope.username}</h1>
<p>This page allows you to file complaints</p>
<form action="homepage" method="post">
<input type="text" name="complaints">
<input type="submit">
</form>
</body>
</html>