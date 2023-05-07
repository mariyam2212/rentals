<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
	<meta charset="UTF-8">
	<%@ page isELIgnored="false" %>
    <title>Renting Properties List</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">

    <script>
    		function openModal(modalname) {
    			document.getElementById(modalname).style.display='block';
    		}
    		function closeModal(modalname) {
    			document.getElementById(modalname).style.display='none';
    		}
    </script>
</head>
<body>
<% String param_city =  request.getParameter("city");
%>

  <div align="center">
    <header>
    		<h3>Welcome, ${sessionScope.first_name}!</h3>
    		<h1>Renting Units List</h1>
    </header>
    <button style="margin:10px" onclick="openModal('filterModal')">Filter</button>
    <div id="filterModal" class="modal">
    	  <!-- MODAL CONTENT -->
              <div class="modal-content">
                            <form action = "filterUnits" method = "post">
                                <input type="hidden" id="city" name="city" value=<%= param_city %>><br><br>
                                <label for="Min_Beds">Enter minimum beds:</label>
                                <input type="text" id="min_beds" name="min_beds">
                                <label for="Max_Beds">Enter maximum beds:</label>
                                <input type="text" id="max_beds" name="max_beds">
                                <label for="Min_Baths">Enter minimum baths:</label>
                                <input type="text" id="min_baths" name="min_baths">
                                <label for="Max_Price">Enter maximum price:</label>
                                <input type="number" id="max_price" name="max_price">
                                <label for="Type">Enter unit type:</label>
                                    <select name="type" id="type">
                                            <option value="All">All</option>
                                            <option value="Apartment">Apartment</option>
                                            <option value="House">House</option>
                                            <option value="Commercial_building">Commercial Building</option>
                                    </select>
                                <input type = "submit" value = "Filter" />
                                <button onclick="closeModal('filterModal')">Close</button>
                            </form>
              </div>
    	</div>

    <div id="moreDetails" class="modal">
    	  <!-- MORE DETAILS MODAL CONTENT -->
              <div class="modal-content">
                                  <p><b>Property: </b><c:out value="${requestScope.property_id}"  /></p>
                                  <p><b>Balconies: </b><c:out value="${requestScope.balconies}"  /></p>
                                  <p><b>Floor number: </b><c:out value="${requestScope.floor_number}"  /></p>
                                  <button onclick="closeModal('moreDetails')">Close</button>
              </div>
    	</div>


    <main>
    <c:forEach var="unit" items="${units}">
      <div class="card">
        <div class="container">
          <h4><b><c:out value="${unit.unit_title}" /></b></h4>
          <p><b>Square Footage: </b><c:out value="${unit.square_footage}" /></p>
          <p><b>Unit Type: </b><c:out value="${unit.unit_type}" /></p>
          <p><b>Beds: </b><c:out value="${unit.number_of_beds}" /></p>
          <p><b>Baths: </b><c:out value="${unit.number_of_bathrooms}" /></p>
          <p><b>Monthly Rent: </b><c:out value="${unit.rent_amount}" /></p>
          <p><b>Property: </b><c:out value="${unit.property_id}" /></p>
          <p><b>Floor Number: </b><c:out value="${unit.floor_number}" /></p>
          <p><b>Number of balconies: </b><c:out value="${unit.number_of_balcony}" /></p>
          <form action="bookingPage" method="post">
          <input type="hidden" name="unit_id" value="${unit.unit_id}">
          <input type="hidden" name="rent" value="${unit.rent_amount}">
             <button type="submit">Book</button>
          </form>
        </div>
      </div>
    </c:forEach>
    </main>
    <form action = "back" method = "post">
       <input type="hidden" name="param_city" value="value1">
        <input type = "submit" value = "Back To Search" />
    </form>
  </div>
</body>
</html>
