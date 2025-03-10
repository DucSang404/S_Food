<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/static/web/assets/css/cart.css' />" rel="stylesheet">
<link rel="stylesheet"
      href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>">

<section class="cart">
    <div class="container">
        <div>
            <button class="back-button">Back</button>
        </div>
        <div class="header">
            <div class="page-title">Your Cart</div>
        </div>
        <div class="cart-items">
            <div class="cart-item">
                <input type="checkbox" class="select-item select-all"> Select All
            </div>

            <c:forEach var="item" items="${cart}">
                <div class="cart-item" data-id="${item.food.id}">
                    <input type="hidden" name="cartId" class="cart-id" value="${cartId}">
                    <input type="checkbox" class="select-item">
                    <img src="/images/menu/${item.food.imgUrl}" alt="" class="cart-item-img">
                    <div class="cart-item-info">
                        <h2 class="cart-item-title">${item.food.name}</h2>
                        <p class="cart-item-description">${item.food.category.name}</p>
                        <p class="cart-item-price">Price: ${item.food.price} VND</p>
                    </div>
                    <div class="cart-item-actions">
                        <div class="quantity-control">
                            <button class="decrease">-</button>
                            <input type="number" class="quantity-input" value="${item.quantity}" min="1" max="10"
                                   readonly>
                            <button class="increase">+</button>
                        </div>
                        <button class="btn-delete" onclick="removeFromCart(${item.food.id})">Delete</button>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="cart-summary">
            <div class="number-choosed">
                <p>Number of items selected: <span id="total-items">0</span></p>
            </div>
            <h3>Total Price: <span id="total-price">0</span> VND</h3>
            <button class="btn-checkout" onclick="proceedToPayment()">Payment</button>
        </div>
    </div>
</section>

<!-- Trong cart.jsp -->
<script>
    const increaseButtons = document.querySelectorAll('.increase');
    const decreaseButtons = document.querySelectorAll('.decrease');

    increaseButtons.forEach(button => {
        button.addEventListener('click', function () {
            const cartItem = button.closest('.cart-item');
            const quantityInput = cartItem.querySelector('.quantity-input');
            let currentQuantity = parseInt(quantityInput.value);
            if (currentQuantity < 10) {
                quantityInput.value = currentQuantity + 1;
                updateCartOnServer(cartItem.dataset.id, quantityInput.value);
            }
        });
    });

    decreaseButtons.forEach(button => {
        button.addEventListener('click', function () {
            const cartItem = button.closest('.cart-item');
            const quantityInput = cartItem.querySelector('.quantity-input');
            let currentQuantity = parseInt(quantityInput.value);
            if (currentQuantity > 1) {
                quantityInput.value = currentQuantity - 1;
                updateCartOnServer(cartItem.dataset.id, quantityInput.value);
            }
        });
    });

    function updateCartOnServer(foodId, quantity) {
        fetch('${pageContext.request.contextPath}/cart/update', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: new URLSearchParams({foodId: foodId, quantity: quantity})
        })
            .then(response => response.json())
            .then(data => {
                if (data.status === "success") {
                    updateCartCount();
                    updateCartSummary();
                }
            })
            .catch(error => console.error('Error:', error));
    }

    function removeFromCart(foodId) {
        fetch('${pageContext.request.contextPath}/cart/remove', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: new URLSearchParams({foodId: foodId})
        })
            .then(response => response.json())
            .then(data => {
                if (data.status === "success") {
                    alert("Removed from cart!");
                    location.reload();
                    updateCartCount();
                }
            })
            .catch(error => console.error('Error:', error));
    }

    function proceedToPayment() {
        const itemCheckBox = document.querySelectorAll('.select-item:not(.select-all)');
        let selectedItems = [];

        itemCheckBox.forEach(checkbox => {
            if (checkbox.checked) {
                const cartItem = checkbox.closest('.cart-item');
                const foodId = cartItem.dataset.id;
                const quantity = cartItem.querySelector('.quantity-input').value;
                const priceText = cartItem.querySelector('.cart-item-price').textContent;
                const price = parseFloat(priceText.replace(/[^0-9.-]+/g, ""));
                const cartId = cartItem.querySelector('.cart-id').value;
                selectedItems.push({
                    foodId: foodId,
                    quantity: quantity,
                    cartId: cartId
                });
                console.log(foodId + "." + quantity + "." + cartId);
            }
        });

        if (selectedItems.length === 0) {
            alert('Choose at least 1 item');
            return;
        }

        fetch('/checkout', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(selectedItems)
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = "/checkout";
                }
            });
    }

    document.addEventListener("DOMContentLoaded", function () {
        const selectAllCheckbox = document.querySelector('.select-all');
        const itemCheckboxes = document.querySelectorAll('.select-item:not(.select-all)');
        const totalItemsSpan = document.getElementById('total-items');
        const totalPriceSpan = document.getElementById('total-price');

        function updateCartSummary() {
            let totalItems = 0;
            let totalPrice = 0;

            itemCheckboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    const cartItem = checkbox.closest('.cart-item');
                    const priceText = cartItem.querySelector('.cart-item-price').textContent;
                    const price = parseFloat(priceText.replace(/[^0-9.-]+/g, ""));
                    const quantity = parseInt(cartItem.querySelector('.quantity-input').value);

                    totalItems += quantity;
                    totalPrice += price * quantity;
                }
            });

            totalItemsSpan.textContent = totalItems;
            totalPriceSpan.textContent = totalPrice.toLocaleString();
        }

        itemCheckboxes.forEach(checkbox => {
            checkbox.addEventListener('change', updateCartSummary);
        });

        selectAllCheckbox.addEventListener('change', function () {
            itemCheckboxes.forEach(checkbox => {
                checkbox.checked = selectAllCheckbox.checked;
            });
            updateCartSummary();
        });

        updateCartSummary();
    });
</script>
