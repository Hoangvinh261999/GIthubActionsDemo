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

        .remember-me {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 16px;
        }


        .remember-me label {
            margin-bottom: 0;
            margin-left: 5px; 
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form action="/asmGd1_java4/index" method="post">
		<div class="cssform">
				        <label for="username">Username:</label>
		        <input type="text" id="username" name="username" required>
		
		        <label for="password">Password:</label>
		        <input type="password" id="password" name="password" required>
		</div>

        <div class="remember-me">
            <div>
                <input type="checkbox" id="remember" name="remember">Remember me?
            </div>
        </div>
	<button>Đăng Nhập</button>
    </form>
</div>

</body>
</html>
