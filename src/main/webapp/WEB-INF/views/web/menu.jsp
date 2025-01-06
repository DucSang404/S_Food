<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/static/web/assets/css/menu.css' />" rel="stylesheet">
<%--<body class="index-page">--%>

<section id="stats" class="stats section dark-background">
    <div class="image-container">
        <img src="/static/web/assets/img/Pic-Page3.jpg" class="background-image">
        <div class="text-overlay">
            <h2>MENU RESTAURANT</h2>
        </div>
    </div>
</section>

<section class="container">
    <div class="filters">
        <select id="category" onchange="filterProducts()">
            <option value="">All Categories</option>
            <option value="electronics">Electronics</option>
            <option value="fashion">Fashion</option>
            <option value="home">Home</option>
        </select>
        <div>
            <input type="text" id="search" placeholder="Search products...">
            <button id="searchButton" onclick="filterProducts()">Search</button>
        </div>
    </div>
    <div id="products" class="product-grid">

        <!-- line 1 -->
        <div class="product-card product__item" data-name="Product 1" data-category="electronics">
            <img src="/static/web/assets/img/menu/menu-item-1.png" class="menu-item-img">
            <btn class="add-cart">+ Add To Cart</btn>
            <h3>Product 1</h3>
            <h3>100$</h3>
            <a href="" class="view_details">View Details</a>
        </div>
        <div class="product-card product__item" data-name="Product 1" data-category="electronics">
            <img src="/static/web/assets/img/menu/menu-item-1.png" class="menu-item-img">
            <btn class="add-cart">+ Add To Cart</btn>
            <h3>Product 1</h3>
            <h3>100$</h3>
            <a href="" class="view_details">View Details</a>
        </div>
        <div class="product-card product__item" data-name="Product 1" data-category="electronics">
            <img src="/static/web/assets/img/menu/menu-item-1.png" class="menu-item-img">
            <btn class="add-cart">+ Add To Cart</btn>
            <h3>Product 1</h3>
            <h3>100$</h3>
            <a href="" class="view_details">View Details</a>
        </div>

        <!-- line 2 -->
        <div class="product-card" data-name="Product 1" data-category="electronics">
            <img src="/assets/img/menu/menu-item-1.png" class="menu-item-img">
            <h3>Product 1</h3>
            <p>Category: Electronics</p>
        </div>
        <div class="product-card" data-name="Product 2" data-category="fashion">
            <img src="/assets/img/menu/menu-item-2.png" class="menu-item-img">
            <h3>Product 2</h3>
            <p>Category: Fashion</p>
        </div>
        <div class="product-card" data-name="Product 3" data-category="home">
            <img src="/assets/img/menu/menu-item-3.png" class="menu-item-img">
            <h3>Product 3</h3>
            <p>Category: Home</p>
        </div>


        <!-- line 3 -->

        <div class="product-card" data-name="Product 1" data-category="electronics">
            <img src="/assets/img/menu/menu-item-1.png" class="menu-item-img">
            <h3>Product 1</h3>
            <p>Category: Electronics</p>
        </div>
        <div class="product-card" data-name="Product 2" data-category="fashion">
            <img src="/assets/img/menu/menu-item-2.png" class="menu-item-img">
            <h3>Product 2</h3>
            <p>Category: Fashion</p>
        </div>
        <div class="product-card" data-name="Product 3" data-category="home">
            <img src="/assets/img/menu/menu-item-3.png" class="menu-item-img">
            <h3>Product 3</h3>
            <p>Category: Home</p>
        </div>

        <!-- Thêm các sản phẩm khác theo cách tương tự -->
    </div>
    <div class="pagination" id="pagination">
        <button class="page-button">1</button>
        <button class="page-button">2</button>
        <button class="page-button">3</button>
    </div>
</section>

<%--</body>--%>
