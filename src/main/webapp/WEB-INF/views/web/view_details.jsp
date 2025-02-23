<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/static/web/assets/css/view_detail.css' />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>">

<div class="product-page">
    <div>
        <button class="back-button">Back</button>
    </div>
    <div class="header">
        <div class="page-title">Product Details</div>
    </div>
    <div class="product-detail">
        <div class="product-left">
            <img src="/images/menu/${food.imgUrl}" class="product-image">
            <h2 class="product-name">${food.name}</h2>
            <p class="product-price">Price: <span>${food.price} $</span></p>
        </div>
        <div class="product-right">
            <h3>About the Product</h3>
            <p class="product-description">
                🥢 Bánh Cuốn (steamed rice rolls) là một món ăn truyền thống nổi tiếng của Việt Nam. Món ăn được làm
                từ những lớp bánh mỏng, mềm mịn, được hấp từ bột gạo.
            </p>
            <p>
                Phần nhân bên trong thường gồm thịt lợn băm nhuyễn, mộc nhĩ và hành phi, tạo nên sự hài hòa giữa
                hương vị và kết cấu. Sau khi cuốn lại, bánh được xếp ra đĩa và rắc thêm hành phi giòn.
            </p>
            <p>
                Bánh thường được ăn kèm với rau thơm tươi như húng, mùi, và đôi khi là chả lụa thái lát. Nước chấm
                nước mắm pha gồm nước mắm, chanh, đường, tỏi, và ớt làm tăng thêm vị đậm đà.
            </p>
            <p>
                Bánh cuốn là lựa chọn lý tưởng cho bữa sáng hoặc món ăn nhẹ, mang đậm nét tinh tế của ẩm thực Việt
                Nam. 🌿🍚✨
            </p>
            <div class="quantity-control">
                <button class="decrease">-</button>
                <input type="number" class="quantity-input" value="1" min="1" max="10" readonly>
                <button class="increase">+</button>
            </div>

            <button class="add-cart">+ Add To Cart</button>
        </div>
    </div>
</div>

<script>
    document.querySelector('.increase').addEventListener('click', function () {
        let quantityInput = document.querySelector('.quantity-input');
        let currentQuantity = parseInt(quantityInput.value);
        quantityInput.value = currentQuantity + 1;
    });

    document.querySelector('.decrease').addEventListener('click', function () {
        let quantityInput = document.querySelector('.quantity-input');
        let currentQuantity = parseInt(quantityInput.value);
        if (currentQuantity > 1) {
            quantityInput.value = currentQuantity - 1;
        }
    });

    quantityInput.addEventListener('input', function () {
        if (parseInt(quantityInput.value) > 10) {
            quantityInput.value = 10;
        }
    });

</script>

<script>
    document.querySelector('.add-cart').addEventListener('click', function () {
        let foodId = '${food.id}';
        let quantity = document.querySelector('.quantity-input').value;

        fetch('/cart/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: new URLSearchParams({ foodId: foodId, quantity: quantity })
        }).then(response => response.json())
            .then(data => {
                if (data.status === "success") {
                    alert("Added to cart successfully!");
                } else {
                    alert("Error: " + data.message);
                }
            }).catch(error => console.error('Error:', error));
    });
</script>

