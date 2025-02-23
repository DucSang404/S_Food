<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section class="greeting-bar">
    <div class="container d-flex justify-content-between align-items-center">
        <c:if test="${not empty user}">
            <span>Hello ${user.name}! Have good day!</span>
            <div>
                <a href="/j_spring_security_logout" class="btn btn-primary">Logout</a>
            </div>
        </c:if>
        <c:if test="${empty user}">
            <span></span>
            <div>
                <a href="/login" class="btn btn-primary">Sign In</a>
                <a href="/register" class="btn btn-secondary">Sign Up</a>
            </div>
        </c:if>
    </div>
</section>

<header id="header" class="header d-flex align-items-center sticky-top">
    <div class="container position-relative d-flex align-items-center justify-content-between">

        <a href="index.html" class="logo d-flex align-items-center me-auto me-xl-0">
            <!-- Uncomment the line below if you also wish to use an image logo -->
            <!-- <img src="assets/img/logo.png" alt=""> -->
            <h1 class="sitename">Yummy</h1>
            <span>.</span>
        </a>

        <nav id="navmenu" class="navmenu">
            <ul>
                <li><a href="/home" class="active">Home<br></a></li>
                <li><a href="#about">About</a></li>
                <li><a href="/menu?page=1&limit=9&category=all">Menu</a></li>
                <li><a href="#events">Events</a></li>
                <li><a href="#chefs">Chefs</a></li>
                <li><a href="#gallery">Gallery</a></li>
                <li>
                    <a href="/cart" class="cart-icon">
                        <i class="bi bi-cart-fill" style="font-size: 1rem;"></i>
                        <span id="cart-count" style="color: red">0</span>
                    </a>
                </li>
                <c:if test="${not empty user}">
                    <li class="dropdown"><a href="#">
                        <div style="display: inline-block; width: 30px; height: 30px; border-radius: 50%; overflow: hidden; vertical-align: middle;">
                            <img src="/images/menu/${user.avatar}" alt="Profile"
                                 style="width: 100%; height: 100%; object-fit: cover;">
                        </div>
                        <i class="bi bi-chevron-down toggle-dropdown"></i></a>
                        <ul>
                            <li><a href="/information">Information</a></li>
                            <li class="dropdown"><a href="#"><span>Deep Dropdown</span> <i
                                    class="bi bi-chevron-down toggle-dropdown"></i></a>
                                <ul>
                                    <li><a href="#">Deep Dropdown 1</a></li>
                                    <li><a href="#">Deep Dropdown 2</a></li>
                                    <li><a href="#">Deep Dropdown 3</a></li>
                                    <li><a href="#">Deep Dropdown 4</a></li>
                                    <li><a href="#">Deep Dropdown 5</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Dropdown 2</a></li>
                            <li><a href="#">Dropdown 3</a></li>
                            <li><a href="#">Dropdown 4</a></li>
                        </ul>
                    </li>
                </c:if>

                <c:if test="${empty user}">
                    <li><a href="/login">Login</a></li>
                </c:if>
            </ul>
            <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>

    </div>
</header>