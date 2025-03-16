<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<link href="<c:url value='/static/web/assets/css/checkout.css'/>" rel="stylesheet">


<div class="container mt-4">
    <div class="row">
        <div class="col-md-7">
            <%--            <h5><a href="${pageContext.request.contextPath}/cart"><i class="fas fa-arrow-left"></i> Continue shopping</a></h5>--%>
            <p>You have <span id="item-count">${cartItem.size()}</span> items in your cart</p>

            <div class="list-group">
                <c:set var="subtotal" value="0"/>
                <c:forEach var="item" items="${cartItem}">
                    <c:set var="itemTotal" value="${item.food.price * item.quantity}" />
                    <c:set var="subtotal" value="${subtotal + itemTotal}"/>
                    <div class="list-group-item d-flex justify-content-between align-items-center">
                        <img src="/images/menu/${item.food.imgUrl}" width="50" alt="${item.food.name}">
                        <span>${item.food.name}</span>
                        <span>${item.quantity}</span>
                        <strong>$${item.food.price * item.quantity}</strong>
                        <i class="fas fa-trash-alt text-danger" onclick="removeItem(${item.food.id})"></i>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="col-md-5">
            <div class="card-details">
                <h5>Card details</h5>

                <div class="mb-3">
                    <label for="receiver-info">Receiver Information:</label>
                    <select id="receiver-info" class="form-control" onchange="updateShippingCost()">
                        <c:forEach var="info" items="${orderInfo}" varStatus="status">
                            <option value="${info.id}" data-province="${info.address.province}" ${status.first ? 'selected' : ''}>
                                    ${info.recipient} - ${info.phone}
                                - ${info.address.street}, ${info.address.ward}, ${info.address.district}, ${info.address.province}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="discount-code">Coupon:</label>
                    <select id="discount-code" class="form-control" onchange="totalCost()">
                        <option value="none">None</option>
                        <c:forEach var="discount" items="${billDiscount}">
                            <option value="${discount.id}" data-discount="${discount.discountPercentage}">
                                ${discount.code} - ${discount.discountPercentage}% OFF
                                | Required: ${discount.loyaltyPointsRequired} points
                                | Min Invoice: ${discount.minimumInvoiceAmount} VND
                                | ${discount.startDate} - ${discount.endDate}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="payment-method">Choose Payment Method:</label>
                    <select id="payment-method" class="form-control mb-2" onchange="toggleQRCode()">
                        <option value="cash">Cash</option>
                        <option value="vnpay">VNPAY QR</option>
                    </select>
                </div>
                <div id="qr-code" class="text-center" style="display: none;">
                    <img src="/assets/img/qrcode.jpg" alt="VNPAY QR Code" class="img-fluid">
                </div>
                <hr>
                <p>Subtotal: <strong id="subtotal-amount">${subtotal} VND</strong></p>
                <p>Discount: <strong id="discount-amount">0</strong> VND</p>
                <p>Shipping: <strong id="shipping-cost">0</strong> VND</p>
                <p>Total: <strong id="total-cost">0</strong> VND</p>
                <button class="checkout-btn">CHECKOUT →</button>
            </div>
        </div>
    </div>
</div>

<script>
    function toggleQRCode() {
        let paymentMethod = document.getElementById("payment-method").value;
        let qrCodeDiv = document.getElementById("qr-code");
        if (paymentMethod === "vnpay") {
            qrCodeDiv.style.display = "block";
        } else {
            qrCodeDiv.style.display = "none";
        }
    }

    function updateShippingCost() {
        let select = document.getElementById("receiver-info");
        let selectedOption = select.options[select.selectedIndex];
        let province = selectedOption.getAttribute("data-province");

        let shippingCost = (province === "Hồ Chí Minh" || province === "Hà Nội") ? 30000 : 50000;

        document.getElementById("shipping-cost").textContent = shippingCost.toString();
        document.addEventListener("DOMContentLoaded", updateShippingCost);

        totalCost();
    }

    function totalCost() {
        let select = document.getElementById("discount-code");
        let selectedOption = select.options[select.selectedIndex];
        let discountPercent = selectedOption.getAttribute("data-discount");

        let subtotal = parseFloat(document.getElementById("subtotal-amount").textContent) || 0;
        let shipping = parseFloat(document.getElementById("shipping-cost").textContent) || 0;

        let total = (subtotal + shipping)
        let discountAmount = total * (discountPercent / 100);
        let finalTotal = total - discountAmount;

        document.getElementById("total-cost").textContent = finalTotal.toString();
        document.getElementById("discount-amount").textContent = '-' + discountAmount.toString();
    }

    window.onload = function () {
        updateShippingCost();
        totalCost();
    }
</script>

<script>
    document.querySelector(".checkout-btn").addEventListener("click", function () {
        let orderInfoId = document.getElementById("receiver-info").value;
        let billDiscount = document.getElementById("discount-code").value !== "none"
            ? document.getElementById("discount-code").value : null;
        let paymentMethod = document.getElementById("payment-method").value;

        let cartId = "${cartId}";
        console.log(cartId);
        let cartItems = [];
        let foodIdList = [];
        document.querySelectorAll(".list-group-item").forEach(item => {
            let foodId = item.querySelector("i").getAttribute("onclick").match(/\d+/)[0];
            let quantity = parseInt(item.children[2].textContent);
            cartItems.push({ foodId, quantity });
            foodIdList.push(foodId);
        });

        let requestData = {
            orderInfoId: orderInfoId,
            billDiscount: billDiscount,
            paymentMethod: paymentMethod,
            cartItems: cartItems,
            foodIdList: foodIdList,
            cartId: cartId
        };

        fetch("/api/order/checkout", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(requestData)
        })
            .then(response => response.text())
            .then(message => {
                alert(message)
            })
            .catch(error => console.log('Error:', error))
    })
</script>

