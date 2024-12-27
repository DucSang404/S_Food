<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link
            href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
            rel="stylesheet"
    />
</head>
<body>
<div class="container">
    <form action="j_spring_security_check" id="formLogin" method="post">
        <h1>Login</h1>
        <c:if test="${param.incorrectAccount != null}">
            <div class="alert alert-danger">
                Username or password is incorrect!
            </div>
        </c:if>

        <c:if test="${param.accessDenied != null}">
            <div class="alert alert-danger">
                You not authorize!
            </div>
        </c:if>

        <div class="input-box">
            <input type="text" id="username" name="j_username" required />
            <label for="username">Username</label>
        </div>
        <div class="input-box">
            <input type="password" id="password" name="j_password" required />
            <label for="password">Password</label>
        </div>

        <div class="remember-forgot">
            <label><input type="checkbox" /> Remember me</label>
            <a href="#">Forgot password?</a>
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="register-link">
            <p>Don't have an account? <a href="/register">Register here!</a></p>
        </div>

        <div class="register-link">
            <p style="color: #fff;">Or login by</p>
        </div>

        <div class="register-link social-icon">
            <!-- Biểu tượng Facebook -->
            <a href="/login/facebook-login" target="_blank">
                <i class="fab fa-facebook"></i>
            </a>

            <!-- Biểu tượng Google -->
            <a href="/login/google-login" target="_blank">
                <i class="fab fa-google"></i>
            </a>
        </div>
    </form>
</div>
</body>
</html>
