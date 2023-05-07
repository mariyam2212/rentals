<html>
<head>
    <%@ page isELIgnored="false" %>
	<title>Retrieve Properties!</title>
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
		input[type="text"] {
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
<%
%>
	<center>
		<h2>Welcome, ${sessionScope.first_name}!</h2>
		<div style="display:inline-flex">
            <form action="gotoProfile" method="post">
                <input type="submit" value="Profile" />
            </form>
            <form action = "logout" method = "post">
                 <input type = "submit" value = "Logout" />
            </form>
        </div>
		<h2>Retrieve Properties!</h2>
		<form class="form-class" action="getProperties" method="post">
			<label for="city">Enter city:</label>
			<input type="text" id="city" name="city" required>
			<br>
			<div>
				<label for="properties">Properties:</label>
				<input type="radio" id="properties" name="selection" value="1">
				<label for="units">Units:</label>
				<input type="radio" id="units" name="selection" value="2">
			</div>
			<br>
			<input type="submit" value="Get Properties" />
		</form>
	</center>
</body>
</html>