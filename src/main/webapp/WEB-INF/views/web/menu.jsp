<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/static/web/assets/css/menu.css' />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>">


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
        <select id="category" onchange="updateCategoryInUrl()">
            <option value="all" ${selectedCategory == 'all' ? 'selected' : ''}>All Categories</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.code}" ${category.code == selectedCategory ? 'selected' : ''}>
                        ${category.name}
                </option>
            </c:forEach>
        </select>
        <div>
            <input type="text" id="search" placeholder="Search...">
            <ul id="suggestions" class="suggestions-dropdown" style="display: none"></ul>
            <button type="button" id="searchButton"><i class="fas fa-search"></i></button>
        </div>
    </div>
    <div id="products" class="product-grid">
        <c:if test="${empty lstFood}">
            <p>No products available</p>
        </c:if>

        <c:forEach var="food" items="${lstFood}">
            <div class="product-card product__item" data-name="Product 1" data-category="electronics" data-id="${food.id}">
                <img src="/images/menu/${food.imgUrl}" class="menu-item-img">
                <btn class="add-cart">+ Add To Cart</btn>
                <h3>${food.name}</h3>
                <h3>${food.price}VND</h3>
                <a href="/view_details/${food.id}" class="view_details">View Details</a>
            </div>
        </c:forEach>
    </div>
    <div class="pagination" id="pagination">
        <%--        <c:forEach var="i" begin="1" end="${pageable.totalPage}">--%>
        <%--            <button class="page-button" onclick="goToPage(${i})">${i}</button>--%>
        <%--        </c:forEach>--%>
        <c:forEach var="i" begin="1" end="${pageable.totalPage}">
            <button href="javascript:void(0);"
                    class="page-button ${i == pageable.page ? 'active' : ''}"
                    onclick="goToPage(${i})">
                    ${i}
            </button>
        </c:forEach>
    </div>
</section>
<%--Pagination--%>
<script type="text/javascript">
    function goToPage(page) {
        var limit = ${pageable.limit};
        var url = '/menu?page=' + page + '&limit=' + limit;
        window.location.href = url;
    }
</script>
<%--Filter--%>
<script type="text/javascript">
    function updateCategoryInUrl() {
        const selectedCategory = document.getElementById('category').value;
        const currentUrl = new URL(window.location.href);

        currentUrl.searchParams.set('category', selectedCategory);

        var page = currentUrl.searchParams.get('page');
        if (!page) {
            currentUrl.searchParams.set('page', 1);
        }
        window.location.href = currentUrl;
    }
</script>
<%--Search--%>
<script>
    const searchInput = document.getElementById("search");
    const suggestionsList = document.getElementById("suggestions");
    const lstFood = [
        <c:forEach var="food" items="${lstFood}">
        "<c:out value='${food.name}' />",
        </c:forEach>
    ];

    function normalizeString(str) {
        return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();
    }

    searchInput.addEventListener('input', function () {
        const searchTerm = normalizeString(searchInput.value.trim());
        suggestionsList.innerHTML = '';
        if(searchTerm.length > 0){
            let matches = lstFood.filter(name => normalizeString(name).includes(searchTerm)).slice(0, 4);
            if(matches.length > 0){
                suggestionsList.style.display = 'block';
                matches.forEach(match => {
                    const li = document.createElement('li');
                    li.classList.add('dropdown-item');
                    li.textContent = match;
                    li.addEventListener('click', function (){
                        searchInput.value = this.textContent;
                        suggestionsList.style.display = 'none';
                        window.location.href = '/menu?page=1&limit=9&name=' + encodeURIComponent(this.textContent);

                    });
                    suggestionsList.appendChild(li);
                })
            }else {
                suggestionsList.style.display = 'block';
                const li = document.createElement('li');
                li.classList.add('dropdown-item');
                li.textContent = "No results";
                suggestionsList.appendChild(li);
            }
        }else {
            suggestionsList.style.display = 'none';

        }
    });

    searchInput.addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            let name = document.getElementById('search').value;
            window.location.href = '/menu?page=1&limit=9&name=' + encodeURIComponent(name);
        }
    });

    document.getElementById("searchButton").addEventListener("click", function () {
        let name = document.getElementById('search').value.trim();
        if (name) {
            window.location.href = '/menu?page=1&limit=9&name=' + encodeURIComponent(name);
        }
    });


</script>

<script>
    document.querySelectorAll('.add-cart').forEach(button => {
        button.addEventListener('click', function () {
            let productCard = this.closest('.product-card');
            let foodId = productCard.getAttribute('data-id');

            fetch('/cart/add', {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ foodId: foodId, quantity: 1 })
            })
                .then(response => response.json())
                .then(data => {
                    if (data.status === "success") {
                        alert("Added to cart successfully!");
                        updateCartCount();
                    } else {
                        alert("Error adding to cart: " + data.message);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    });

    function updateCartCount() {
        fetch('/cart/count')
            .then(response => response.json())
            .then(data => {
                document.getElementById('cart-count').textContent = data.count;
            })
            .catch(error => console.error('Error updating cart count:', error))
    }
</script>



