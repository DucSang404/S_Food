<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
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
    <form action="/register" method="post">
        <div class="image"></div>
        <div class="form-container">
            <div id="step1" class="form active">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <spring:message text="${error}"/>
                    </div>
                </c:if>

                <!-- Display success message -->
                <c:if test="${not empty success}">
                    <div class="alert alert-success">
                        <spring:message text="${success}"/>
                    </div>
                </c:if>
                <h2>Step 1: Create Your Account</h2><br>
                <div class="input-box">
                    <input type="text" name="username" placeholder="Username" required>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Re-enter password" required>
                </div>
                <button type="button" class="btn next">Next</button>
            </div>
            <div id="step2" class="form">
                <h2>Step 2: Personal Information</h2><br>
                <div class="input-box">
                    <input type="text" name="name" placeholder="Full Name" required>
                </div>
                <div class="input-box">
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-box">
                    <input type="text" name="phone" placeholder="Phone Number" required>
                </div>
                <div class="input-box">
                    <input type="date" name="dateOfBirth" placeholder="" required>
                </div>
                <div class="button-group">
                    <button type="button" class="btn back">Back</button>
                    <button type="submit" class="btn submit">Submit</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
