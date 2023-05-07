<!DOCTYPE html>
<html>
  <head>
    <title>Add Property for Renting</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
        	<meta charset="UTF-8">
        	<%@ page isELIgnored="false" %>
        	<style>
        	    body {
                			background-color: #f2f2f2;
                		}
                		.form-class {
                			background-color: #fff;
                			padding: 20px;
                			border-radius: 10px;
                			box-shadow: 0px 0px 10px #aaa;
                			width: 400px;
                		}
                		form {
                		    margin: 10px;
                		}
                		input[type="text"], input[type="number"]{
                			width: 100%;
                			padding: 10px;
                			border-radius: 5px;
                			margin-bottom: 10px;
                			box-sizing: border-box;
                		}
                		label {
                			font-size: 20px;
                			color: #4CAF50;
                			margin-bottom: 10px;
                		}
                		input[type="radio"] {
                			margin-right: 10px;
                			transform: translateY(2px);
                		}
                		input[type="submit"] {
                			background-color: #4CAF50;
                			color: #fff;
                			padding: 10px 20px;
                			border-radius: 5px;
                			border: none;
                			cursor: pointer;
                			font-size: 20px;
                			margin-top: 10px;
                			transition: all 0.3s ease-in-out;
                		}
                		input[type="submit"]:hover {
                			background-color: #005b5b;
                		}
        	</style>
  </head>
  <body>
    <h1>Add Property for Renting</h1>
    <main>
    <form action="addProperty" method="POST">
      <label for="property_name">Title:</label>
      <input type="text" id="property_name" name="property_name" required><br>

      <label for="total_units">Total Units:</label>
      <input type="text" id="total_units" name="total_units" required></textarea><br>

      <label for="address">Address:</label>
      <input type="text" id="address" name="address" required><br>

      <label for="street_name">Street Name:</label>
      <input type="text" id="street_name" name="street_name" required><br>

      <label for="state">State:</label>
      <input type="text" id="state" name="state" required><br>

      <label for="city">city:</label>
      <input type="text" id="city" name="city" required><br>

      <label for="country">country:</label>
      <input type="text" id="country" name="country" required><br>

      <label for="zip_code">zip_code:</label>
      <input type="text" id="zip_code" name="zip_code" required><br>

      <label for="total_floors">total_floors:</label>
      <input type="number" id="total_floors" name="total_floors" required><br>

      <label for="bedrooms">Bedrooms:</label>
      <input type="number" id="bedrooms" name="bedrooms" required><br>

      <label for="bathrooms">Bathrooms:</label>
      <input type="number" id="bathrooms" name="bathrooms" required><br>

      <label for="rent">Rent:</label>
      <input type="number" id="rent" name="rent" required><br>

      <label for="has_parking">
              <input type="checkbox" id="has_parking" name="has_parking" value="true"> Has Parking
       </label><br>

      <label for="has_laundry">
              <input type="checkbox" id="has_laundry" name="has_laundry" value="true"> Has Laundry
       </label><br>

      <label for="is_pet_friendly">
              <input type="checkbox" id="is_pet_friendly" name="is_pet_friendly" value="true"> Is Pet Friendly
       </label><br>

      <input type="submit" value="Submit">
    </form>
    </main>
  </body>
</html>