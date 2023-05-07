<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Add CSS styles here -->
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

        input[type="text"], input[type="password"], input[type="submit"] {
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
    <h1>Login Page</h1>
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <form action="login" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" value="Login">
    </form>
</body>
</html>
