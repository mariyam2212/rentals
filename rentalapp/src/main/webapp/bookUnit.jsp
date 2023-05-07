<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                background-color: #ffffff;
                border: 1px solid #cccccc;
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
                color: #4CAF50;
                text-align: center;
            }
	</style>
</head>
<body>
<center>
	<h1>Rental Property Booking Form</h1>
	<p>Welcome, ${sessionScope.first_name}!, Book your property. Monthly Rent Amount: ${sessionScope.rent}</p>
	<main>
	<form action="addBookingInfo" method="post">

		<label for="checkIn">Lease Start Date:</label>
		<input type="date" id="startDate" name="startDate" required>

		<label for="checkOut">Lease End Date:</label>
		<input type="date" id="endDate" name="endDate" required>

		<label for="PaymentMethod">Select Payment Method:</label>
            <select name="paymentMethod" id="paymentMethod">
                    <option value="1">Debit</option>
                    <option value="2">Credit</option>
            </select>
        <br>
		<label for="cardName">Cardholder Name:</label>
		<input type="text" id="cardName" name="cardName" required>

		<label for="cardNumber">Card Number:</label>
		<input type="text" id="cardNumber" name="cardNumber" required>

		<label for="expiryDate">Expiry Date:</label>
		<input type="month" id="expiryDate" name="expiryDate" required><br>

		<label for="cvv">CVV:</label>
		<input type="password" id="cvv" name="cvv" maxlength="3" required>

		<input type="submit" value="Book Now">
	</form>
	</main>
</center>
</body>
</html>
