<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Bao gồm CSS của trang và thêm Bootstrap CSS từ Code2 -->
<link href="<c:url value='/static/web/assets/css/information.css' />" rel="stylesheet">
<link href="<c:url value='/static/web/assets/css/address.css' />" rel="stylesheet">
<link rel="stylesheet"
      href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'/>">

<div class="button-back">
    <button class="btn btn-back" onclick="goBack()">Back</button>
</div>
<div class="user-info-form">
    <!-- Header -->
    <div class="user-header">
        <div class="container" style="width: 30%; height: 30%;">
            <img id="avtImage" src="/images/menu/${cus.avatar}" alt="Avatar" class="image">
            <div class="middle">
                <button class="text" onclick="document.getElementById('fileInput').click();">
                    <i style="font-size:16px" class="fa">&#xf030;</i>
                </button>
                <input type="file" id="fileInput" accept="image/*" style="display: none" onchange="previewImage(event)">
            </div>
        </div>
        <h3 id="displayName" style="color: white;">${cus.name}</h3>
        <p style="color: white;">Loyalty Points: <strong style="color: #e45050;">${cus.loyaltyPoints}</strong></p>
        <a href="#" class="address-cus" data-bs-toggle="modal" data-bs-target="#addressModal">My Address</a>

        <!-- Modal địa chỉ được thay thế (từ Code2) -->
        <div class="modal fade" id="addressModal" data-bs-backdrop="false" tabindex="-1"
             aria-labelledby="addressModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addressModalLabel">Order Information</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <c:forEach var="info" items="${lstOrderInfo}" varStatus="status">
                            <div class="address-block" data-address-id="1">
                                <p><strong>Recipient:</strong>${info.recipient}</p>
                                <p><strong>Phone:</strong>${info.phone}</p>
                                <p><strong>Address:</strong>
                                        ${info.address.street}, ${info.address.ward}, ${info.address.district}, ${info.address.province}
                                </p>

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="defaultAddress"
                                           id="defaultAddress${info.id}" value="${info.id}"
                                           <c:if test="${status.first}">checked="checked"</c:if>>
                                </div>

                                <button type="button" class="btn btn-warning mt-2 edit-address-btn"
                                        data-bs-toggle="modal"
                                        data-bs-target="#editAddressModal"
                                        data-info-id="${info.id}"
                                        data-recipient="${info.recipient}"
                                        data-phone="${info.phone}"
                                        data-street="${info.address.street}"
                                        data-ward="${info.address.ward}"
                                        data-district="${info.address.district}"
                                        data-province="${info.address.province}">
                                    Edit Address
                                </button>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="saveDefaultBtn">Save</button>
                        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                data-bs-target="#addAddressModal">
                            Add Address
                        </button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal chỉnh sửa địa chỉ -->
        <div class="modal fade" id="editAddressModal" data-bs-backdrop="false" tabindex="-1"
             aria-labelledby="editAddressModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editAddressModalLabel">Edit Address</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <input type="hidden" id="info-id" name="infoId" value="">

                            <div class="mb-3">
                                <label for="recipient" class="form-label">Recipient:</label>
                                <input type="text" class="form-control" id="recipient-edit"
                                       required>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone:</label>
                                <input type="text" class="form-control" id="phone-edit"
                                       required
                                       pattern="^0\d{9}$">
                            </div>
                            <div class="mb-3">
                                <label for="street" class="form-label">Street:</label>
                                <input type="text" class="form-control" id="street" required>
                            </div>
                            <div class="mb-3">
                                <label for="ward" class="form-label">Ward:</label>
                                <input type="text" class="form-control" id="ward" required>
                            </div>
                            <div class="mb-3">
                                <label for="district" class="form-label">District:</label>
                                <input type="text" class="form-control" id="district" required>
                            </div>
                            <div class="mb-3">
                                <label for="province" class="form-label">Province:</label>
                                <input type="text" class="form-control" id="province" required>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="editAddressBtn">Save</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Thêm địa chỉ -->
        <div class="modal fade" id="addAddressModal" data-bs-backdrop="false" tabindex="-1"
             aria-labelledby="addAddressModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addAddressModalLabel">Add address</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="addAddressForm">
                            <div class="mb-3">
                                <label for="recipient" class="form-label">Recipient:</label>
                                <input type="text" class="form-control" id="recipient" placeholder="Enter recipient"
                                       required>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone:</label>
                                <input type="text" class="form-control" id="phone-add" placeholder="Enter phone"
                                       required
                                       pattern="^0\d{9}$">
                            </div>
                            <div class="mb-3">
                                <label for="provinceSelect" class="form-label">Province:</label>
                                <select class="form-select" id="provinceSelect" required>
                                    <option value="">Select Province</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="districtSelect" class="form-label">District:</label>
                                <select class="form-select" id="districtSelect" required disabled>
                                    <option value="">Select District</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="wardSelect" class="form-label">Ward:</label>
                                <select class="form-select" id="wardSelect" required disabled>
                                    <option value="">Select Ward</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="newHouseNumber" class="form-label">Street:</label>
                                <input type="text" class="form-control" id="newHouseNumber" placeholder="Enter street"
                                       required>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="addAddressBtn">Save</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Kết thúc modal địa chỉ mới -->

        <!-- Details -->
        <div class="user-details">
            <div class="form-group">
                <label for="name" class="label-info">Name</label>
                <input type="text" id="name" value="${cus.name}" readonly>
            </div>
            <div class="form-group">
                <label for="email" class="label-info">Email</label>
                <input type="email" id="email" value="${cus.email}" readonly>
            </div>
            <div class="form-group">
                <%--@declare id="phone"--%><label for="phone" class="label-info">Phone</label>
                <input type="text" id="phone" value="${cus.phone}" readonly>
            </div>
            <div class="form-group">
                <label for="dob" class="label-info">Date of Birth</label>
                <input type="date" id="dob" value="${dob}" readonly>
            </div>
            <!-- Buttons -->
            <div class="button-group">
                <button id="updateBtn" class="btn btn-update" onclick="toggleEdit()">Update Information</button>
                <button id="saveBtn" class="btn btn-save" onclick="saveInformation()" style="display: none">Save
                </button>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script>
    function toggleEdit() {
        const saveBtn = document.getElementById("saveBtn");
        const updateBtn = document.getElementById("updateBtn");
        const inputs = document.querySelectorAll('.form-group input');

        if (updateBtn.textContent === "Update Information") {
            inputs.forEach(input => input.removeAttribute('readonly'));
            updateBtn.textContent = "Cancel";
            saveBtn.style.display = "inline-block";
        } else {
            inputs.forEach(input => input.setAttribute('readonly', true));
            updateBtn.textContent = "Update Information";
            saveBtn.style.display = "none";
        }
    }

    function saveInformation() {
        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const phone = document.getElementById("phone").value;
        const dob = document.getElementById("dob").value;

        const customerData = {
            name: name,
            email: email,
            phone: phone,
            dateOfBirth: dob
        };

        fetch("/api/update-customer-info", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(customerData)
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    document.getElementById("displayName").innerText = customerData.name;
                    alert("Update successful!")
                    toggleEdit();
                } else {
                    alert("Update failed. Please try again.")
                }
            })
            .catch(error => console.error("Error:", error))
    }
</script>


<%--Change Image--%>
<script>
    function previewImage(event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById('avtImage').src = e.target.result;
            }
            reader.readAsDataURL(file)

            uploadImage(file);
        }

        function uploadImage(file) {
            let formData = new FormData();
            formData.append("avatar", file)
            formData.append("name", document.getElementById("name").value);
            formData.append("email", document.getElementById("email").value);
            formData.append("phone", document.getElementById("phone").value);
            formData.append("dateOfBirth", document.getElementById("dob").value);

            fetch("/api/update-customer-info", {
                method: "POST",
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert("Change image successful!")
                        toggleEdit();
                    } else {
                        alert("Error change image")
                    }
                })
                .catch(error => console.error("Error:", error))
        }
    }
</script>

<script>
    function updateDefaultBadge() {
        document.querySelectorAll('.default-badge').forEach(badge => badge.remove());
        const selectedRadio = document.querySelector('input[name="defaultAddress"]:checked');
        if (selectedRadio) {
            const badge = document.createElement('span');
            badge.classList.add('badge', 'bg-success', 'ms-2', 'default-badge');
            badge.textContent = 'Default';
            selectedRadio.parentElement.appendChild(badge);
        }
    }

    updateDefaultBadge();

    document.querySelectorAll('input[name="defaultAddress"]').forEach(function (radio) {
        radio.addEventListener('change', updateDefaultBadge);
    });

    document.getElementById('saveDefaultBtn').addEventListener('click', function () {
        const selectedRadio = document.querySelector('input[name="defaultAddress"]:checked');
        if (selectedRadio) {
            const addressId = selectedRadio.closest('.address-block').getAttribute('data-address-id');
            alert('Default address has saved with ID: ' + addressId);
        } else {
            alert('Please choose default address before saved.');
        }
    });
</script>


<%--api dia chi--%>

<script>
    document.addEventListener('DOMContentLoaded', function () {

        async function loadProvinces() {
            const response = await fetch('/api/provinces');
            const data = await response.json();

            const provinceSelect = document.getElementById('provinceSelect');
            provinceSelect.innerHTML = '<option value="">Select Province</option>';
            data.forEach(province => {
                const option = document.createElement('option');
                option.value = province.ProvinceID;
                option.textContent = province.ProvinceName;
                provinceSelect.appendChild(option);
            });
        }

        async function loadDistricts(provinceId) {
            const response = await fetch("/api/districts?provinceId=" + encodeURIComponent(provinceId));
            const data = await response.json();

            const districtSelect = document.getElementById('districtSelect');
            districtSelect.innerHTML = '<option value="">Select District</option>';
            data.forEach(district => {
                const option = document.createElement('option');
                option.value = district.DistrictID;
                option.textContent = district.DistrictName;
                districtSelect.appendChild(option);
            });
            districtSelect.disabled = false;
        }

        async function loadWards(districtId) {
            const response = await fetch("/api/wards?districtId=" + encodeURIComponent(districtId));
            const data = await response.json();

            const wardSelect = document.getElementById('wardSelect');
            wardSelect.innerHTML = '<option value="">Select Ward</option>';
            data.forEach(ward => {
                const option = document.createElement('option');
                option.value = ward.WardCode;
                option.textContent = ward.WardName;
                wardSelect.appendChild(option);
            });
            wardSelect.disabled = false;
        }

        var addAddressModal = document.getElementById('addAddressModal');
        addAddressModal.addEventListener('show.bs.modal', function () {
            loadProvinces();
            document.getElementById('districtSelect').innerHTML = '<option value="">Select District</option>';
            document.getElementById('districtSelect').disabled = true;
            document.getElementById('wardSelect').innerHTML = '<option value="">Select Ward</option>';
            document.getElementById('wardSelect').disabled = true;
        });

        document.getElementById('provinceSelect').addEventListener('change', function () {
            const provinceId = this.value;
            if (provinceId) {
                loadDistricts(provinceId);
            }
        });

        document.getElementById('districtSelect').addEventListener('change', function () {
            const districtId = this.value;
            if (districtId) {
                loadWards(districtId);
            }
        });

    });
</script>

<%--Add Address--%>

<script>
    $(document).ready(function () {
        $("#addAddressBtn").click(function () {
            var addressData = {
                recipient: $("#recipient").val().trim(),
                phone: $("#phone").val().trim(),
                address: {
                    province: $("#provinceSelect option:selected").text(),
                    district: $("#districtSelect option:selected").text(),
                    ward: $("#wardSelect option:selected").text(),
                    street: $("#newHouseNumber").val().trim()
                },
                isDefault: false
            };


            $.ajax({
                url: "/api/add-order-info",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(addressData),
                success: function (response) {
                    $("#addAddressModal").modal("hide");
                    alert("Address added successfully!");
                },
                error: function (xhr, status, error) {
                    console.error("Error adding address:", error);
                    alert("Error adding address: " + error);
                }
            });
        });
    });
</script>

<%--Edit Address--%>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const editButtons = document.querySelectorAll(".edit-address-btn")

        editButtons.forEach(button => {
            button.addEventListener("click", function () {
                const id = this.getAttribute("data-info-id")
                const recipient = this.getAttribute("data-recipient");
                const phone = this.getAttribute("data-phone");
                const street = this.getAttribute("data-street");
                const ward = this.getAttribute("data-ward");
                const district = this.getAttribute("data-district");
                const province = this.getAttribute("data-province");

                document.getElementById("info-id").value = id;
                document.getElementById("recipient-edit").value = recipient;
                document.getElementById("phone-edit").value = phone;
                document.getElementById("street").value = street;
                document.getElementById("ward").value = ward;
                document.getElementById("district").value = district;
                document.getElementById("province").value = province;
            });
        });
    });

    $(document).ready(function () {
        $("#editAddressBtn").click(function () {
            var addressData = {
                id: $("#info-id").val().trim(),
                recipient: $("#recipient-edit").val().trim(),
                phone: $("#phone-edit").val().trim(),
                address: {
                    province: $("#province option:selected").text(),
                    district: $("#district option:selected").text(),
                    ward: $("#ward option:selected").text(),
                    street: $("#street").val().trim()
                },
                isDefault: false
            };


            $.ajax({
                url: "/api/update-order-info",
                type: "PUT",
                contentType: "application/json",
                data: JSON.stringify(addressData),
                success: function (response) {
                    $("#addAddressModal").modal("hide");
                    alert("Update order info successfully!");
                },
                error: function (xhr, status, error) {
                    alert("Error update info: " + error);
                }
            });
        });
    });
</script>