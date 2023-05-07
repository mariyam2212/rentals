<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Renter Registration</title>
<script>
		function showDiv(divId) {
			var div = document.getElementById(divId);
			if (div.style.display === "none") {
				div.style.display = "block";
			}
		}
		function hideDiv(divId) {
			var div = document.getElementById(divId);
			div.style.display = "none";
		}
</script>
<style>
        body {
            background-color: #f1f1f1;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
        }

        form {
            background-color: #ffffff;
            border: 1px solid #cccccc;
            padding: 20px;
            width: 50%;
            margin: 0 auto;
        }

        input[type="text"], input[type="password"], input[type="number"], input[type="submit"] {
            display: block;
            margin-bottom: 10px;
            padding: 10px;
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
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Renter Registration</h1>
    <form action="register" method="post" novalidate>
        <label for="first name">First Name:</label>
        <input type="text" id="first_name" name="first_name" required><br>
        <label for="last name">Last Name:</label>
        <input type="text" id="last_name" name="last_name" required><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="contact">Contact Number:</label>
        <input type="text" id="contact" name="contact" required><br>
        <label>User Type:</label><br>
        <center>
            <div>
                <label for="renter">Renter</label>
                <input type="radio" id="renter" name="user_type" value="1" onclick="showDiv('address'), hideDiv('renterInfo')">
                <label for="agent">Agent</label>
                <input type="radio" id="agent" name="user_type" value="2" onclick="hideDiv('address'), showDiv('renterInfo')">
                <br>
            </div>
        </center><br>
    <div id="address" style="display:none">
            <label for="street">Street Address:</label>
            <input type="text" id="street" name="street" required><br><br>
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required><br><br>
            <label for="state">State:</label>
            <input type="text" id="state" name="state" required><br><br>
            <label for="zip">Zip Code:</label>
            <input type="text" id="zip" name="zip" required><br><br>
        </div>
        <div id="renterInfo" style="display:none">
            <label for="job type">Job Type:</label>
            <input type="text" id="job_type" name="job_type" required><br><br>
            <label for="agency">Agency:</label>
            <input type="text" id="agency" name="agency" required><br><br>
        </div>
        <input type="submit" value="Register">
    </form>
</body>
</html>
