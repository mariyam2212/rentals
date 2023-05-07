<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="UTF-8">
    <title>Renting Properties List</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
  <div align="center">
    <header>
    		<h1>Renting Properties List</h1>
    </header>
    <main>
    <c:forEach var="property" items="${properties}">
      <div class="card">
        <div class="container">
          <h4><b><c:out value="${property.property_name}" /></b></h4>
          <p><b>Address: </b><c:out value="${property.address}" /></p>
          <p><b>City: </b><c:out value="${property.city}" /></p>
          <p><b>State: </b><c:out value="${property.state}" /></p>
          <p><b>Country: </b><c:out value="${property.country}" /></p>
          <p><b>Zip Code: </b><c:out value="${property.zip_code}" /></p>
          <p><b>Total Units: </b><c:out value="${property.total_units}" /></p>
          <p><b>Total Floors: </b><c:out value="${property.total_floors}" /></p>
          <p><b>Laundry: </b><c:out value="${property.has_laundry}" /></p>
          <p><b>Parking: </b><c:out value="${property.has_parking}" /></p>
          <p><b>Pet Friendly: </b><c:out value="${property.is_pet_friendly}" /></p>
          <p><b>Rating: </b><c:out value="${property.rating}" /></p>
        </div>
      </div>
    </c:forEach>
    </main>
    <form action = "back" method = "post">
      <input type = "submit" value = "Back To Search" />
    </form>
  </div>
</body>
</html>
