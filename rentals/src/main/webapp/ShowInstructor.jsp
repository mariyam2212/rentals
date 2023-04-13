<%@ page import="com.cs425.web.model.Instructor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instructor Information</title>
</head>
<body>
  <%
    Instructor ob2 = (Instructor) request.getAttribute("Instructor");
    out.println(ob2);
  %>
</body>
</html>