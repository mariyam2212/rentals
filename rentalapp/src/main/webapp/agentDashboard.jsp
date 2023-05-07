<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
    	<meta charset="UTF-8">
    	<%@ page isELIgnored="false" %>
    	<title>Rental Property Booking Form</title>
    	<style>
    	body {
                    background-color: #f1f1f1;
                    font-family: Arial, sans-serif;
                }

                h1 {
                    text-align: center;
                }

                form {
                    padding: 10px;
                    width: 50%;
                    margin: 0 auto;
                }

                input[type="text"], input[type="password"], input[type="date"], input[type="submit"], select {
                    display: block;
                    margin-bottom: 5px;
                    padding: 5px;
                    width: 100%;
                    box-sizing: border-box;
                    border: 1px solid #cccccc;
                    border-radius: 3px;
                }

                input[type="submit"] {
                    background-color: #4CAF50;
                    color: #ffffff;
                    font-size: 16px;
                    border: none;
                    cursor: pointer;
                    padding: 10px 20px;
                }

                input[type="submit"]:hover {
                    background-color: #3e8e41;
                }

                label {
                    display: inline-block;
                    margin-bottom: 5px;
                }

                p {
                    text-align: center;
                }

                .bookings-table {
                    border-collapse: collapse;
                    width: 100%;
                }

                .bookings-table th, .bookings-table td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                }

                .bookings-table th {
                    background-color: #f2f2f2;
                }

                .bookings-table tr:nth-child(even) {
                    background-color: #f2f2f2;
                }

                .bookings-table tr:hover {
                    background-color: #ddd;
                }
    	</style>
</head>
<body>
	<h1>Agent ${sessionScope.first_name} Dashboard</h1>
	<h2>Bookings</h2>
	<c:if test="${empty bookings}">
		<p>No bookings yet.</p>
	</c:if>
	<c:if test="${not empty bookings}">
	</c:if>
	<h2>Profile Information</h2>
	<p><strong>Name:</strong> ${sessionScope.user_info.first_name}</p>
	<p><strong>Email:</strong> ${sessionScope.user_info.email}</p>
	<p><strong>Phone:</strong> ${sessionScope.user_info.contact_no}</p>

<center>
        <div style="display:inline-flex">
                    <form action="addPropertyRedirect" method="post">
                        <input type="submit" value="Add Property" />
                    </form>
                    <form action="deleteProperty" method="post">
                        <input type="submit" value="Delete Property" />
                    </form>
                    <form action="updateProperty" method="post">
                        <input type="submit" value="Update Property" />
                    </form>
                    <form action = "logout" method = "post">
                         <input type = "submit" value = "Logout" />
                    </form>
        </div>
</center>
</body>
</html>
