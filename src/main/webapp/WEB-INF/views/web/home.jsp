<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- Hero Section -->
<section id="hero" class="hero section light-background">

    <div class="container">
        <div class="row gy-4 justify-content-center justify-content-lg-between">
            <div class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center">
                <h1 data-aos="fade-up">Enjoy Your Healthy<br>Delicious Food</h1>
                <p data-aos="fade-up" data-aos-delay="100">Delicious Meals Delivered Fresh to Your Doorstep
                </p>
                <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
                </div>
            </div>
            <div class="col-lg-5 order-1 order-lg-2 hero-img" data-aos="zoom-out">
                <img src="/static/web/assets/img/hero-img.png" class="img-fluid animated" alt="">
            </div>
        </div>
    </div>

</section>
<!-- /Hero Section -->

<!-- About Section -->
<section id="about" class="about section">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>About Us<br></h2>
        <p><span>Learn More</span> <span class="description-title">About Us</span></p>
    </div><!-- End Section Title -->

    <div class="container">

        <div class="row gy-4">
            <div class="col-lg-7" data-aos="fade-up" data-aos-delay="100">
                <img src="<c:url value='/static/web/assets/img/about.jpg'/>" class="img-fluid mb-4" alt="">
                <div class="book-a-table">
                    <h3>Book a Table</h3>
                    <p>+1 5589 55488 55</p>
                </div>
            </div>
            <div class="col-lg-5" data-aos="fade-up" data-aos-delay="250">
                <div class="content ps-0 ps-lg-5">
                    <p class="fst-italic">
                        At our restaurant, we pride ourselves on offering a unique dining experience with fresh
                        ingredients, exquisite flavors,
                        and a cozy ambiance.
                    </p>
                    <ul>
                        <li><i class="bi bi-check-circle-fill"></i> <span>Fresh Ingredients: We use locally-sourced, high-quality ingredients in every dish.</span>
                        </li>
                        <li><i class="bi bi-check-circle-fill"></i> <span>Unique Flavors: Our chefs create mouthwatering meals inspired by international and traditional cuisines.</span>
                        </li>
                        <li><i class="bi bi-check-circle-fill"></i> <span>Warm Ambiance: Relax in a stylish, comfortable space perfect for any occasion.</span>
                        </li>
                    </ul>
                    <p>
                        Our team of dedicated chefs and staff ensures that every meal is crafted to perfection, blending
                        taste, quality, and presentation.
                        Join us for an unforgettable dining experience where great food meets exceptional service.
                    </p>

                    <div class="position-relative mt-4">
                        <img src="<c:url value="/static/web/assets/img/Pic-page2.jpg"/>" class="img-fluid" alt="">
                    </div>
                </div>
            </div>
        </div>

    </div>

</section>
<!-- /About Section -->

<!-- Why Us Section -->
<section id="why-us" class="why-us section light-background">

    <div class="container">

        <div class="row gy-4">

            <div class="col-lg-4" data-aos="fade-up" data-aos-delay="100">
                <div class="why-box">
                    <h3>Why You Choose S-Food</h3>
                    <p style="text-align: justify;">
                        S-Food is your go-to destination for fresh, delicious, and satisfying meals.
                        We take pride in using only the finest ingredients to create dishes that are bursting with
                        flavor and crafted with care. Our diverse menu offers something for everyone,
                        whether you’re in the mood for a quick bite, a family feast, or a special treat.
                    </p>
                    <div class="text-center">
                        <a href="#" class="more-btn"><span>Learn More</span> <i class="bi bi-chevron-right"></i></a>
                    </div>
                </div>
            </div><!-- End Why Box -->

            <div class="col-lg-8 d-flex align-items-stretch">
                <div class="row gy-4" data-aos="fade-up" data-aos-delay="200">

                    <div class="col-xl-4">
                        <div class="icon-box d-flex flex-column justify-content-center align-items-center">
                            <i class="bi bi-clipboard-data"></i>
                            <h4>Fresh Ingredients Guaranteed
                            </h4>
                            <p style="text-align: center;">All of our ingredients are sourced daily to ensure that you
                                enjoy meals that are not only delicious but also healthy and safe.</p>
                        </div>
                    </div><!-- End Icon Box -->

                    <div class="col-xl-4" data-aos="fade-up" data-aos-delay="300">
                        <div class="icon-box d-flex flex-column justify-content-center align-items-center">
                            <i class="bi bi-gem"></i>
                            <h4>Premium Dining Experience
                            </h4>
                            <p style="text-align: center;">Every meal is carefully crafted to offer a perfect balance of
                                flavor, presentation, and satisfaction.</p>
                        </div>
                    </div><!-- End Icon Box -->

                    <div class="col-xl-4" data-aos="fade-up" data-aos-delay="400">
                        <div class="icon-box d-flex flex-column justify-content-center align-items-center">
                            <i class="bi bi-inboxes"></i>
                            <h4>Fast & Reliable Delivery
                            </h4>
                            <p style="text-align: center;">With quick, reliable service, S-Food makes sure your food
                                arrives fresh, hot, and ready to savor wherever you are.</p>
                        </div>
                    </div><!-- End Icon Box -->

                </div>
            </div>

        </div>

    </div>

</section>
<!-- /Why Us Section -->

<!-- Stats Section -->
<section id="stats" class="stats section dark-background">

    <img src="<c:url value="/static/web/assets/img/Pic-Page3.jpg"/>" alt="" data-aos="fade-in">

    <div class="container position-relative" data-aos="fade-up" data-aos-delay="100">
        <div class="row gy-4">
            <div class="col-lg-3 col-md-6">
                <div class="stats-item text-center w-100 h-100">
                    <span data-purecounter-start="0" data-purecounter-end="232" data-purecounter-duration="1"
                          class="purecounter"></span>
                    <p>Main Course</p>
                </div>
            </div><!-- End Stats Item -->

            <div class="col-lg-3 col-md-6">
                <div class="stats-item text-center w-100 h-100">
                    <span data-purecounter-start="0" data-purecounter-end="521" data-purecounter-duration="1"
                          class="purecounter"></span>
                    <p>Appetizers</p>
                </div>
            </div><!-- End Stats Item -->

            <div class="col-lg-3 col-md-6">
                <div class="stats-item text-center w-100 h-100">
                    <span data-purecounter-start="0" data-purecounter-end="1453" data-purecounter-duration="1"
                          class="purecounter"></span>
                    <p>Dessert</p>
                </div>
            </div><!-- End Stats Item -->

            <div class="col-lg-3 col-md-6">
                <div class="stats-item text-center w-100 h-100">
                    <span data-purecounter-start="0" data-purecounter-end="32" data-purecounter-duration="1"
                          class="purecounter"></span>
                    <p>Beverage</p>
                </div>
            </div><!-- End Stats Item -->

        </div>

    </div>

</section>
<!-- /Stats Section -->

<!-- Menu Section -->
<section id="menu" class="menu section">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>Our Menu</h2>
        <p><span class="description-title">Menu Overview</span></p>
    </div><!-- End Section Title -->

    <div class="container">

        <ul class="nav nav-tabs d-flex justify-content-center" data-aos="fade-up" data-aos-delay="100">

            <li class="nav-item">
                <a class="nav-link active show" data-bs-toggle="tab" data-bs-target="#menu-starters">
                    <h4>Main Course</h4>
                </a>
            </li><!-- End tab nav item -->

            <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" data-bs-target="#menu-breakfast">
                    <h4>Appetizers</h4>
                </a><!-- End tab nav item -->

            </li>
            <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" data-bs-target="#menu-lunch">
                    <h4>Dessert</h4>
                </a>
            </li><!-- End tab nav item -->

            <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" data-bs-target="#menu-dinner">
                    <h4>Beverage</h4>
                </a>
            </li><!-- End tab nav item -->

        </ul>

        <div class="tab-content" data-aos="fade-up" data-aos-delay="200">

            <div class="tab-pane fade active show" id="menu-starters">

                <div class="tab-header text-center">
                    <p>Menu</p>
                    <h3>Signature Dish</h3>
                </div>

                <div class="row gy-5">

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Magnam Tiste</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $5.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Aut Luia</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $14.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Est Eligendi</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $8.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Laboriosam Direva</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $9.95
                        </p>
                    </div><!-- Menu Item -->

                </div>
            </div><!-- End Starter Menu Content -->

            <div class="tab-pane fade" id="menu-breakfast">

                <div class="tab-header text-center">
                    <p>Menu</p>
                    <h3>Signature Dish</h3>
                </div>

                <div class="row gy-5">

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Magnam Tiste</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $5.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Aut Luia</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $14.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Est Eligendi</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $8.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Laboriosam Direva</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $9.95
                        </p>
                    </div><!-- Menu Item -->

                </div>
            </div><!-- End Breakfast Menu Content -->

            <div class="tab-pane fade" id="menu-lunch">

                <div class="tab-header text-center">
                    <p>Menu</p>
                    <h3>Signature Dish</h3>
                </div>

                <div class="row gy-5">

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Magnam Tiste</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $5.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Aut Luia</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $14.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-3.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Est Eligendi</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $8.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-4.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-5.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Eos Luibusdam</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $12.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-6.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Laboriosam Direva</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $9.95
                        </p>
                    </div><!-- Menu Item -->

                </div>
            </div><!-- End Lunch Menu Content -->

            <div class="tab-pane fade" id="menu-dinner">

                <div class="tab-header text-center">
                    <p>Menu</p>
                    <h3>Signature Dish</h3>
                </div>

                <div class="row gy-5">

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-1.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Magnam Tiste</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $5.95
                        </p>
                    </div><!-- Menu Item -->

                    <div class="col-lg-4 menu-item">
                        <a href="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="glightbox"><img
                                src="<c:url value="/static/web/assets/img/menu/menu-item-2.png"/>" class="menu-img img-fluid" alt=""></a>
                        <h4>Aut Luia</h4>
                        <p class="ingredients">
                            Lorem, deren, trataro, filede, nerada
                        </p>
                        <p class="price">
                            $14.95
                        </p>
                    </div><!-- Menu Item -->

                </div>
            </div><!-- End Dinner Menu Content -->

        </div>

    </div>

</section>
<!-- /Menu Section -->

<!-- Testimonials Section -->
<section id="testimonials" class="testimonials section light-background">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>TESTIMONIALS</h2>
        <p>What Are They <span class="description-title">Saying About Us</span></p>
    </div><!-- End Section Title -->

    <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="swiper init-swiper">
            <script type="application/json" class="swiper-config">
                {
                    "loop": true,
                    "speed": 600,
                    "autoplay": {
                        "delay": 5000
                    },
                    "slidesPerView": "auto",
                    "pagination": {
                        "el": ".swiper-pagination",
                        "type": "bullets",
                        "clickable": true
                    }
                }
            </script>
            <div class="swiper-wrapper">

                <div class="swiper-slide">
                    <div class="testimonial-item">
                        <div class="row gy-4 justify-content-center">
                            <div class="col-lg-6">
                                <div class="testimonial-content">
                                    <p>
                                        <i class="bi bi-quote quote-icon-left"></i>
                                        <span>Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.</span>
                                        <i class="bi bi-quote quote-icon-right"></i>
                                    </p>
                                    <h3>Gordon Ramsay</h3>
                                    <h4>Chef</h4>
                                    <div class="stars">
                                        <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 text-center">
                                <img src="<c:url value="/static/web/assets/img/testimonials/ramsay.png"/>" class="img-fluid testimonial-img" alt="">
                            </div>
                        </div>
                    </div>
                </div><!-- End testimonial item -->

                <div class="swiper-slide">
                    <div class="testimonial-item">
                        <div class="row gy-4 justify-content-center">
                            <div class="col-lg-6">
                                <div class="testimonial-content">
                                    <p>
                                        <i class="bi bi-quote quote-icon-left"></i>
                                        <span>Export tempor illum tamen malis malis eram quae irure esse labore quem cillum quid cillum eram malis quorum velit fore eram velit sunt aliqua noster fugiat irure amet legam anim culpa.</span>
                                        <i class="bi bi-quote quote-icon-right"></i>
                                    </p>
                                    <h3>Joe Bastianich</h3>
                                    <h4>Designer</h4>
                                    <div class="stars">
                                        <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 text-center">
                                <img src="<c:url value="/static/web/assets/img/testimonials/joe.jpg"/>" class="img-fluid testimonial-img" alt="">
                            </div>
                        </div>
                    </div>
                </div><!-- End testimonial item -->

                <div class="swiper-slide">
                    <div class="testimonial-item">
                        <div class="row gy-4 justify-content-center">
                            <div class="col-lg-6">
                                <div class="testimonial-content">
                                    <p>
                                        <i class="bi bi-quote quote-icon-left"></i>
                                        <span>Enim nisi quem export duis labore cillum quae magna enim sint quorum nulla quem veniam duis minim tempor labore quem eram duis noster aute amet eram fore quis sint minim.</span>
                                        <i class="bi bi-quote quote-icon-right"></i>
                                    </p>
                                    <h3>Graham Elliot</h3>
                                    <h4>Store Owner</h4>
                                    <div class="stars">
                                        <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 text-center">
                                <img src="<c:url value="/static/web/assets/img/testimonials/graham.jpg"/>" class="img-fluid testimonial-img" alt="">
                            </div>
                        </div>
                    </div>
                </div><!-- End testimonial item -->

                <div class="swiper-slide">
                    <div class="testimonial-item">
                        <div class="row gy-4 justify-content-center">
                            <div class="col-lg-6">
                                <div class="testimonial-content">
                                    <p>
                                        <i class="bi bi-quote quote-icon-left"></i>
                                        <span>Fugiat enim eram quae cillum dolore dolor amet nulla culpa multos export minim fugiat minim velit minim dolor enim duis veniam ipsum anim magna sunt elit fore quem dolore labore illum veniam.</span>
                                        <i class="bi bi-quote quote-icon-right"></i>
                                    </p>
                                    <h3>Luca</h3>
                                    <h4>Chef</h4>
                                    <div class="stars">
                                        <i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i
                                            class="bi bi-star-fill"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 text-center">
                                <img src="<c:url value="/static/web/assets/img/testimonials/luca.jpg"/>" class="img-fluid testimonial-img" alt="">
                            </div>
                        </div>
                    </div>
                </div><!-- End testimonial item -->

            </div>
            <div class="swiper-pagination"></div>
        </div>

    </div>

</section>
<!-- /Testimonials Section -->

<!-- Events Section -->
<section id="events" class="events section">

    <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

        <div class="swiper init-swiper">
            <script type="application/json" class="swiper-config">
                {
                    "loop": true,
                    "speed": 600,
                    "autoplay": {
                        "delay": 5000
                    },
                    "slidesPerView": "auto",
                    "pagination": {
                        "el": ".swiper-pagination",
                        "type": "bullets",
                        "clickable": true
                    },
                    "breakpoints": {
                        "320": {
                            "slidesPerView": 1,
                            "spaceBetween": 40
                        },
                        "1200": {
                            "slidesPerView": 3,
                            "spaceBetween": 1
                        }
                    }
                }
            </script>
            <div class="swiper-wrapper">

                <div class="swiper-slide event-item d-flex flex-column justify-content-end"
                     style="background-image: url(/static/web/assets/img/events-1.jpg)">
                    <h3>Custom Parties</h3>
                    <div class="price align-self-start">$99</div>
                    <p class="description">
                        Quo corporis voluptas ea ad. Consectetur inventore sapiente ipsum voluptas eos omnis facere.
                        Enim facilis veritatis id est rem repudiandae nulla expedita quas.
                    </p>
                </div><!-- End Event item -->

                <div class="swiper-slide event-item d-flex flex-column justify-content-end"
                     style="background-image: url(/static/web/assets/img/events-2.jpg)">
                    <h3>Private Parties</h3>
                    <div class="price align-self-start">$289</div>
                    <p class="description">
                        In delectus sint qui et enim. Et ab repudiandae inventore quaerat doloribus. Facere nemo vero
                        est ut dolores ea assumenda et. Delectus saepe accusamus aspernatur.
                    </p>
                </div><!-- End Event item -->

                <div class="swiper-slide event-item d-flex flex-column justify-content-end"
                     style="background-image: url(/static/web/assets/img/events-3.jpg)">
                    <h3>Birthday Parties</h3>
                    <div class="price align-self-start">$499</div>
                    <p class="description">
                        Laborum aperiam atque omnis minus omnis est qui assumenda quos. Quis id sit quibusdam. Esse
                        quisquam ducimus officia ipsum ut quibusdam maxime. Non enim perspiciatis.
                    </p>
                </div><!-- End Event item -->

                <div class="swiper-slide event-item d-flex flex-column justify-content-end"
                     style="background-image: url(/static/web/assets/img/events-4.jpg)">
                    <h3>Wedding Parties</h3>
                    <div class="price align-self-start">$899</div>
                    <p class="description">
                        Laborum aperiam atque omnis minus omnis est qui assumenda quos. Quis id sit quibusdam. Esse
                        quisquam ducimus officia ipsum ut quibusdam maxime. Non enim perspiciatis.
                    </p>
                </div><!-- End Event item -->

            </div>
            <div class="swiper-pagination"></div>
        </div>

    </div>

</section>
<!-- /Events Section -->

<!-- Chefs Section -->
<section id="chefs" class="chefs section">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>chefs</h2>
        <p><span>Our</span> <span class="description-title">Proffesional Chefs<br></span></p>
    </div><!-- End Section Title -->

    <div class="container">

        <div class="row gy-4">

            <div class="col-lg-4 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                <div class="team-member">
                    <div class="member-img">
                        <img src="<c:url value="/static/web/assets/img/chefs/chefs-1.jpg"/>" class="img-fluid" alt="">
                        <div class="social">
                            <a href=""><i class="bi bi-twitter-x"></i></a>
                            <a href=""><i class="bi bi-facebook"></i></a>
                            <a href=""><i class="bi bi-instagram"></i></a>
                            <a href=""><i class="bi bi-linkedin"></i></a>
                        </div>
                    </div>
                    <div class="member-info">
                        <h4>Walter White</h4>
                        <span>Master Chef</span>
                        <p>Velit aut quia fugit et et. Dolorum ea voluptate vel tempore tenetur ipsa quae aut. Ipsum
                            exercitationem iure minima enim corporis et voluptate.</p>
                    </div>
                </div>
            </div><!-- End Chef Team Member -->

            <div class="col-lg-4 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="200">
                <div class="team-member">
                    <div class="member-img">
                        <img src="<c:url value="/static/web/assets/img/chefs/chefs-2.jpg"/>" class="img-fluid" alt="">
                        <div class="social">
                            <a href=""><i class="bi bi-twitter-x"></i></a>
                            <a href=""><i class="bi bi-facebook"></i></a>
                            <a href=""><i class="bi bi-instagram"></i></a>
                            <a href=""><i class="bi bi-linkedin"></i></a>
                        </div>
                    </div>
                    <div class="member-info">
                        <h4>Sarah Jhonson</h4>
                        <span>Patissier</span>
                        <p>Quo esse repellendus quia id. Est eum et accusantium pariatur fugit nihil minima suscipit
                            corporis. Voluptate sed quas reiciendis animi neque sapiente.</p>
                    </div>
                </div>
            </div><!-- End Chef Team Member -->

        </div>

    </div>

</section>
<!-- /Chefs Section -->

<!-- Book A Table Section -->
<section id="book-a-table" class="book-a-table section">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>Book A Table</h2>
        <p><span>Book Your</span> <span class="description-title">Stay With Us<br></span></p>
    </div><!-- End Section Title -->

    <div class="container">

        <div class="row g-0" data-aos="fade-up" data-aos-delay="100">

            <div class="col-lg-4 reservation-img"
                 style="background-image: url(/static/web/assets/img/reservation.jpg);"></div>

            <div class="col-lg-8 d-flex align-items-center reservation-form-bg" data-aos="fade-up" data-aos-delay="200">
                <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form">
                    <div class="row gy-4">
                        <div class="col-lg-4 col-md-6">
                            <input type="text" name="fisrtName" class="form-control" id="fisrtName"
                                   placeholder="Your First Name" required="">
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <input type="text" name="lastName" class="form-control" id="lastName"
                                   placeholder="Your Last Name" required="">
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email"
                                   required="">
                        </div>

                    </div>
                    <div class="text-center mt-3">
                        <div class="loading">Loading</div>
                        <div class="error-message"></div>
                        <div class="sent-message">Your booking request was sent. We will call back or send an Email to
                            confirm your reservation. Thank you!
                        </div>
                        <button type="submit">Book a Table</button>
                    </div>
                </form>
            </div><!-- End Reservation Form -->

        </div>

    </div>

</section>
<!-- /Book A Table Section -->

<!-- Gallery Section -->
<section id="gallery" class="gallery section light-background">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>Gallery</h2>
        <p><span>Check</span> <span class="description-title">Our Gallery</span></p>
    </div><!-- End Section Title -->

    <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="swiper init-swiper">
            <script type="application/json" class="swiper-config">
                {
                    "loop": true,
                    "speed": 600,
                    "autoplay": {
                        "delay": 5000
                    },
                    "slidesPerView": "auto",
                    "centeredSlides": true,
                    "pagination": {
                        "el": ".swiper-pagination",
                        "type": "bullets",
                        "clickable": true
                    },
                    "breakpoints": {
                        "320": {
                            "slidesPerView": 1,
                            "spaceBetween": 0
                        },
                        "768": {
                            "slidesPerView": 3,
                            "spaceBetween": 20
                        },
                        "1200": {
                            "slidesPerView": 5,
                            "spaceBetween": 20
                        }
                    }
                }
            </script>
            <div class="swiper-wrapper align-items-center">
                <div class="swiper-slide"><a class="glightbox" data-gallery="images-gallery"
                                             href="<c:url value="/static/web/assets/img/gallery/gallery-1.jpg"/>"><img
                        src="<c:url value="/static/web/assets/img/gallery/gallery-1.jpg"/>" class="img-fluid" alt=""></a></div>
                <div class="swiper-slide"><a class="glightbox" data-gallery="images-gallery"
                                             href="<c:url value="/static/web/assets/img/gallery/gallery-2.jpg"/>"><img
                        src="<c:url value="/static/web/assets/img/gallery/gallery-2.jpg"/>" class="img-fluid" alt=""></a></div>
                <div class="swiper-slide"><a class="glightbox" data-gallery="images-gallery"
                                             href="<c:url value="/static/web/assets/img/gallery/gallery-3.jpg"/>"><img
                        src="<c:url value="/static/web/assets/img/gallery/gallery-3.jpg"/>" class="img-fluid" alt=""></a></div>
                <div class="swiper-slide"><a class="glightbox" data-gallery="images-gallery"
                                             href="<c:url value="/static/web/assets/img/gallery/gallery-4.jpg"/>"><img
                        src="<c:url value="/static/web/assets/img/gallery/gallery-4.jpg"/>" class="img-fluid" alt=""></a></div>
            </div>
            <div class="swiper-pagination"></div>
        </div>

    </div>

</section>
<!-- /Gallery Section -->

<!-- Contact Section -->
<section id="contact" class="contact section">

    <!-- Section Title -->
    <div class="container section-title" data-aos="fade-up">
        <h2>Contact</h2>
        <p><span>Need Help?</span> <span class="description-title">Contact Us</span></p>
    </div><!-- End Section Title -->

    <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="mb-5">
            <iframe style="width: 100%; height: 400px;"
                    src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621"
                    frameborder="0" allowfullscreen=""></iframe>
        </div><!-- End Google Maps -->

        <div class="row gy-4">

            <div class="col-md-6">
                <div class="info-item d-flex align-items-center" data-aos="fade-up" data-aos-delay="200">
                    <i class="icon bi bi-geo-alt flex-shrink-0"></i>
                    <div>
                        <h3>Address</h3>
                        <p>A108 Adam Street, New York, NY 535022</p>
                    </div>
                </div>
            </div><!-- End Info Item -->

            <div class="col-md-6">
                <div class="info-item d-flex align-items-center" data-aos="fade-up" data-aos-delay="300">
                    <i class="icon bi bi-telephone flex-shrink-0"></i>
                    <div>
                        <h3>Call Us</h3>
                        <p>+1 5589 55488 55</p>
                    </div>
                </div>
            </div><!-- End Info Item -->

            <div class="col-md-6">
                <div class="info-item d-flex align-items-center" data-aos="fade-up" data-aos-delay="400">
                    <i class="icon bi bi-envelope flex-shrink-0"></i>
                    <div>
                        <h3>Email Us</h3>
                        <p>info@example.com</p>
                    </div>
                </div>
            </div><!-- End Info Item -->

            <div class="col-md-6">
                <div class="info-item d-flex align-items-center" data-aos="fade-up" data-aos-delay="500">
                    <i class="icon bi bi-clock flex-shrink-0"></i>
                    <div>
                        <h3>Opening Hours<br></h3>
                        <p><strong>Mon-Sat:</strong> 11AM - 23PM; <strong>Sunday:</strong> Closed</p>
                    </div>
                </div>
            </div><!-- End Info Item -->

        </div>
    </div>

</section>
<!-- /Contact Section -->
