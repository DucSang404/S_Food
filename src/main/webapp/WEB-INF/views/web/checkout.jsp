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
                <c:forEach var="item" items="${cartItem}">
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
                    <select id="receiver-info" class="form-control">
                        <c:forEach var="info" items="${orderInfo}">
                            <option value="${info.id}">
                                    ${info.recipient} - ${info.phone}
                                - ${info.address.street}, ${info.address.ward}, ${info.address.district}, ${info.address.province}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="discount-code">Coupon:</label>
                    <select id="discount-code" class="form-control">
                        <option value="none">None</option>
                        <c:forEach var="discount" items="${billDiscount}">
                            <option value="${discount.id}">
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
                <p>Subtotal: <strong>4798.00 VND</strong></p>
                <p>Shipping: <strong>20.00 VND</strong></p>
                <p>Total<strong>4818.00 VND</strong></p>
                <button class="checkout-btn">4818.00 VND CHECKOUT →</button>
            </div>
        </div>
    </div>
</div>

<script>
    function toggleQRCode() {
        var paymentMethod = document.getElementById("payment-method").value;
        var qrCodeDiv = document.getElementById("qr-code");
        if (paymentMethod === "vnpay") {
            qrCodeDiv.style.display = "block";
        } else {
            qrCodeDiv.style.display = "none";
        }
    }
</script>

