<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Books Store Application</title>
</head>
<body>
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of properties</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Total Units</th>
                <th>Total Floors</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>Zip Code</th>
                <th>Address</th>
                <th>Laundry</th>
                <th>Parking</th>
                <th>Pet Friendly</th>
                <th>Rating</th>
            </tr>
            <c:forEach var="property" items="${properties}">
                <tr>
                    <td><c:out value="${property.property_id}" /></td>
                    <td><c:out value="${property.property_name}" /></td>
                    <td><c:out value="${property.total_units}" /></td>
                    <td><c:out value="${property.total_floors}" /></td>
                    <td><c:out value="${property.street_name}" /></td>
                    <td><c:out value="${property.city}" /></td>
                    <td><c:out value="${property.state}" /></td>
                    <td><c:out value="${property.country}" /></td>
                    <td><c:out value="${property.zip_code}" /></td>
                    <td><c:out value="${property.address}" /></td>
                    <td><c:out value="${property.has_laundry}" /></td>
                    <td><c:out value="${property.has_parking}" /></td>
                    <td><c:out value="${property.is_pet_friendly}" /></td>
                    <td><c:out value="${property.rating}" /></td>
                </tr>
            </c:forEach>
        </table>
        <form action = "back" method = "post">
             <input type = "submit" value = "Back To Search" />
        </form>
 </div>
</body>
</html>

