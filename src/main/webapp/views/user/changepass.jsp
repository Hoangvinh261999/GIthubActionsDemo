<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>


        .login-container {
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
            width: 300px;
            text-align: center;
            margin: 0 auto;
        }

        .login-container h2 {
            margin-bottom: 20px;
        }

        .login-container label {
            display: block;
            margin-bottom: 8px;
            text-align: left;
        }

        .cssform input{
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
                height: 30px;
    width: 80px;
        }

        .login-container input[type="submit"]:hover {
            background-color: #45a049;
        }


    </style>
</head>
<body>

<div class="login-container">
    <h2>Change Pass</h2>
    <form action="#" method="post">
		<div class="cssform">
				        <label for="username">Username:</label>
		        <input type="text" id="username" name="username" required>

		        <label for="password">Current Password:</label>
		        <input type="text" id="password" name="password" required>
		        
		      <label for="fullname">New password:</label>
		     <input type="text" id="newpass" name="newpass" required>
		     
		     		        <label for="email">Confirm new password:</label>
		     <input type="text" id="cfpass" name="cfpass" required>
		</div>
        <input type="submit" value="Sign up" >
    </form>
</div>

</body>
</html>
